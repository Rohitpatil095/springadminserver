package com.office.portal.employee.batchchannel.jobs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.portal.employee.batchchannel.config.SpringBatchConfig;
import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.fetchPendingStatusResponseList;

@Service
public class ApplyLeaveJobRunner {

	@Autowired private SpringBatchConfig springBatchConfig;
	@Autowired private Dto dto;
	@Autowired private JobRepository jobRepository;
	@Autowired private CreateEmployeeResponse createEmployeeResponse;
	private static String supervisorEmail;
	private static fetchPendingStatusResponseList currEmpLeaveDetails;
	
    private final JobLauncher jobLauncher;
//    private final Job leaveNotificationJobFactory;
    private JobExecution jobExecution;

    public void setSupervisorMail(String supervisorEmail) 
    {
    	this.supervisorEmail= supervisorEmail;
    }
    
    public void setCurrEmpLeaveDetails(fetchPendingStatusResponseList currEmpLeaveDetails) 
    {
    	this.currEmpLeaveDetails= currEmpLeaveDetails;
    }
    
    public void setSpringBatchConfig(SpringBatchConfig springBatchConfig)
    {
    	this.springBatchConfig=springBatchConfig;
    }
    
    @Autowired
	public ApplyLeaveJobRunner(JobLauncher jobLauncher)
	{
		this.jobLauncher= jobLauncher;
	}
    
	
//	@Async
	public void run()
	{
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("ApplyLeaveJobRunner-startAt", System.currentTimeMillis())
                .toJobParameters();
		try {
			jobExecution = jobLauncher.run(springBatchConfig.leaveNotificationJobFactory(), jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
//		Job a=springBatchConfig.leaveNotificationJobFactory(jobRepository, dto.getCreateEmployeeResponse());
//		System.out.println("Job printing from async ApplyLeaveJobRunner---- "+ jobExecution.toString() );
	}
}
