package com.office.portal.employee.batchchannel.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.office.portal.employee.batchchannel.jobs.LeaveNotificationStepFactory;
import com.office.portal.employee.batchchannel.jobs.LeavesDataExtractorStepExecutor;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.FetchEmployeeApplyLeavePendingStatusResponseArray;
import com.office.portal.employee.infra.response.fetchPendingStatusResponseList;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	private LeaveNotificationStepFactory leaveNotificationStepFactory;
	private LeavesDataExtractorStepExecutor leavesDataExtractorStepExecutor;
	public JobRepository jobRepository;
	public PlatformTransactionManager transactionManager; 

	@Autowired
	public SpringBatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			LeaveNotificationStepFactory leaveNotificationStepFactory,
			LeavesDataExtractorStepExecutor leavesDataExtractorStepExecutor) {
		this.jobRepository = jobRepository;
		this.transactionManager = transactionManager;
		this.leaveNotificationStepFactory = leaveNotificationStepFactory;
		this.leavesDataExtractorStepExecutor = leavesDataExtractorStepExecutor;
	}

	public Job leaveNotificationJobFactory() {
		JobBuilder jobBuilder = new JobBuilder("leaveNotificationJobFactory", jobRepository);
//		Step leaveNotificationStep = leaveNotificationStepFactory.leaveNotificationStepfactoryCreator(
//				transactionManager, jobRepository, supervisorEmail, currEmpLeaveDetails);
//		
		return jobBuilder
				.start(extractLeaves(transactionManager,jobRepository))
				.next(leaveNotificationStepfactoryCreator(transactionManager,jobRepository))
				.build();

		
//				return new JobBuilder("leaveNotificationJobFactory",jobRepository)
//				.start(leaveNotificationStepFactory.leaveNotificationStepfactory(jobRepository, createEmployeeResponse))
//				.build();
		
//		return new jobBuilders.get("leaveNotificationJobFactory")
//		.start(leaveNotificationStepFactory.leaveNotificationStepfactory(stepBuilders, createEmployeeResponse))
////		.next(spfEvaluationTasklet())
//		.build();
	}

//	@Bean
	public Step leaveNotificationStepfactoryCreator(PlatformTransactionManager transactionManager,
			JobRepository jobRepository) {
		System.out.println("inside leaveNotificationStepfactoryCreator Step");
		return new StepBuilder("leaveNotificationStep", jobRepository)
				.tasklet(leaveNotificationStepFactory)
				.transactionManager(transactionManager)
				.build();
	}
	
//	@Bean
	public Step extractLeaves(PlatformTransactionManager transactionManager, 
			JobRepository jobRepository
			) {
		
		System.out.println("inside extractLeaves step");
		return new StepBuilder("leavesExtractorStep", jobRepository)
				.tasklet(leavesDataExtractorStepExecutor)
				.transactionManager(transactionManager)
				.build();
	}


//	public Job LeavesExtractorFactory(FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending,
//			SpringBatchConfig springBatchConfig) {
//		JobBuilder jobBuilder = new JobBuilder("LeavesExtractorFactoryJob", jobRepository);
//		Step leavesDataExtractorStep = leavesDataExtractorStepExecutor.extractLeaves(transactionManager, jobRepository);
//		return jobBuilder.start(leavesDataExtractorStep).build();
//	}

}
