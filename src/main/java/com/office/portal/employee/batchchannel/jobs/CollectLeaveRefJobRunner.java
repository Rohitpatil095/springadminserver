//package com.office.portal.employee.batchchannel.jobs;
//
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import com.office.portal.employee.batchchannel.config.SpringBatchConfig;
//import com.office.portal.employee.infra.response.FetchEmployeeApplyLeavePendingStatusResponseArray;
//
//@Service
//public class CollectLeaveRefJobRunner {
//	@Autowired private SpringBatchConfig springBatchConfig;
//	private final JobLauncher jobLauncher;
//	private JobExecution jobExecution;
//	private FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending;
//
//    @Autowired
//	public CollectLeaveRefJobRunner(JobLauncher jobLauncher)
//	{
//		this.jobLauncher= jobLauncher;
//	}
//    
//    public void setFetchEmployeeApplyLeavePendingStatusResponseArray(FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending)
//    {
//    	this.employeeWithLeaveStatusPending=employeeWithLeaveStatusPending;
//    }
//    
////	@Async
//	public void run() {
//		JobParameters jobParameters = new JobParametersBuilder()
//				.addLong("CollectLeaveRefJobRunner-startAt", System.currentTimeMillis()).toJobParameters();
//		try {
//			jobExecution = jobLauncher.run(
//					springBatchConfig.LeavesExtractorFactory(employeeWithLeaveStatusPending,springBatchConfig), jobParameters);
//		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
//				| JobParametersInvalidException e) {
//			e.printStackTrace();
//		}
////		Job a=springBatchConfig.leaveNotificationJobFactory(jobRepository, dto.getCreateEmployeeResponse());
////		System.out.println("Job printing from async CollectLeaveRefJobRunner---- " + jobExecution.toString());
//	}
//}
