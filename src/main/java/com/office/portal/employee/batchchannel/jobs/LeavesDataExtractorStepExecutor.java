package com.office.portal.employee.batchchannel.jobs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.office.portal.employee.businessservice.EmployeeApplyLeaveService;
import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.impl.IDBEmployeeImpl;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.FetchEmployeeApplyLeavePendingStatusResponseArray;
import com.office.portal.employee.infra.response.fetchPendingStatusResponseList;

@Service
@StepScope
public class LeavesDataExtractorStepExecutor implements Tasklet {

	@Autowired
	private IDBEmployeeImpl idbImpl;

	@Autowired
	private ApplyLeaveJobRunner leaveJobRunner;

	@Autowired
	private Dto dto;

	@Autowired
	private ObjectMapper objectMapper;

	private FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending;
	
	@Autowired private EmployeeApplyLeaveService empApplyLeaveService;

	public void SetemployeeWithLeaveStatusPending(
			FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending) {
		this.employeeWithLeaveStatusPending = employeeWithLeaveStatusPending;
	}

//	@Autowired
//	FetchEmployeeApplyLeavePendingStatusResponseArray fetchEmployeeApplyLeavePendingStatusResponseArray;
//
//	public void setEmpPendingStatusArray(
//			FetchEmployeeApplyLeavePendingStatusResponseArray fetchEmployeeApplyLeavePendingStatusResponseArray) {
//		this.fetchEmployeeApplyLeavePendingStatusResponseArray = fetchEmployeeApplyLeavePendingStatusResponseArray;
//	}

//	@Bean
//	public Step extractLeaves(PlatformTransactionManager transactionManager, 
//			JobRepository jobRepository,
//			FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending,
//			SpringBatchConfig springBatchConfig
//			) {
//		
//		System.out.println("inside extractLeaves step");
//		return new StepBuilder("leavesExtractorStep", jobRepository)
//				.tasklet(LeavesChunkFormator(employeeWithLeaveStatusPending,springBatchConfig ))
//				.transactionManager(transactionManager).build();
//	}

//	private Tasklet LeavesChunkFormator(FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending, SpringBatchConfig springBatchConfig) {
//		return new Tasklet() {
//
//			@Override
//			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//				System.out.println("inside LeavesChunkFormator Tasklet");
////				ExecutionContext jobContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
////				String serializedValues = null;
//				int size=0;
//				System.out.println(employeeWithLeaveStatusPending.getPendingStatusResponses().size()+"------size");
//				
//				for (int i = 0; i<=employeeWithLeaveStatusPending.getPendingStatusResponses().size()
//						/ 10; i += 10) {
//					System.out.println("inside loop"+i);
////					size =employeeWithLeaveStatusPending.getPendingStatusResponses().size()-1;
//					
////					if(size<11)
////					{
////						serializedValues=objectMapper.writeValueAsString(employeeWithLeaveStatusPending.getPendingStatusResponses().subList(0,size));
////					}
////					else if((size-i)<11)
////					{
////						serializedValues=objectMapper.writeValueAsString(employeeWithLeaveStatusPending.getPendingStatusResponses().subList(i,size));
////					}
////					else
////					{						
////						serializedValues=objectMapper.writeValueAsString(employeeWithLeaveStatusPending.getPendingStatusResponses().subList(i, i + 10));
////					}
//	
//					
//					size =employeeWithLeaveStatusPending.getPendingStatusResponses().size();
//					ArrayList<fetchPendingStatusResponseList> empLeaveRef=new ArrayList<>();
//					if(size<11)
//					{
//						System.out.println("inside---" + size);
//						System.out.println(employeeWithLeaveStatusPending.getPendingStatusResponses().subList(0,size).toString());
//						empLeaveRef.addAll(employeeWithLeaveStatusPending.getPendingStatusResponses().subList(0,size));
//					}
//					else if((size-i)<11)
//					{
//						empLeaveRef.addAll(employeeWithLeaveStatusPending.getPendingStatusResponses().subList(i,size));
//					}
//					else
//					{						
//						empLeaveRef.addAll(employeeWithLeaveStatusPending.getPendingStatusResponses().subList(i, i + 10));
//					}
//					
//					for (int j = 0; j < empLeaveRef.size(); j++) {
//						Long empId= Long.parseLong(empLeaveRef.get(i).getEmployeeReference().split("_")[1]);
//						CreateEmployeeResponse resp= idbImpl.getEmployeeByEmployeeId(empId);
////						if(!resp.getSupervisor_Email().equals(null))
////						{
////							leaveJobRunner.setCurrEmpLeaveDetails(empLeaveRef.get(j));
////							leaveJobRunner.setSupervisorMail(dto.getCreateEmployeeResponse().getSupervisor_Email());
////							
////							// need some validation after that pass return finished;
////							leaveJobRunner.setSpringBatchConfig(springBatchConfig);
////							leaveJobRunner.run();
////						}
//					}
//					
//					
////					
////					System.out.println("sez value "+ serializedValues.toString());
////					chunkContext.getStepContext().getStepExecution().getExecutionContext().putString("employeeWithLeaveStatusPending",employeeWithLeaveStatusPending);
//		            
////					LeavesDataExtractorForLeaveIdAndEmpRef(springBatchConfig).execute(contribution, chunkContext);
//					
////					jobContext.put("empApplyLeaveSublist",employeeWithLeaveStatusPending
////							.getPendingStatusResponses().subList(i, i + 10));
//					
////					System.out.println("-----------"+employeeWithLeaveStatusPending
////							.getPendingStatusResponses().subList(i, i + 10));
//				}
//
//				// some validation to check is task completed then send finished
//				return RepeatStatus.FINISHED;
//			}
//		};
//	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("inside LeavesChunkFormator Tasklet");
		ExecutionContext jobContext = chunkContext.getStepContext().getStepExecution().getJobExecution()
				.getExecutionContext();
//		String serializedValues = null;
		ArrayList<CreateEmployeeResponse> empRef = new ArrayList<>();

		empApplyLeaveService.GetEmployeeApplyLeaveDetailsForPendingLeaveStatus("Pending",dto);
		
		List<fetchPendingStatusResponseList> employeeWithLeaveStatusPending= dto.getFetchEmployeeApplyLeavePendingStatusResponseArray().getPendingStatusResponses();
//		applyLeaveJobRunner.setFetchEmployeeApplyLeavePendingStatusResponseArray(employeeWithLeaveStatusPending);
		
		for (int i = 0; i < employeeWithLeaveStatusPending.size(); i++) {
			System.out.println("inside loop" + i);
			System.out.println(employeeWithLeaveStatusPending.get(i).getEmployeeReference().split("_"));
			Long empId = Long.parseLong(employeeWithLeaveStatusPending.get(i)
					.getEmployeeReference().split("_")[1]);
			empRef.add(idbImpl.getEmployeeByEmployeeId(empId));
		
		}
//		serializedValues = objectMapper.writeValueAsString(resp);
//		System.out.println("ser1 -"+serializedValues.toString());
		jobContext.put("employeeRefDetails", empRef);
//		serializedValues = objectMapper.writeValueAsString(employeeWithLeaveStatusPending);

//		System.out.println("ser2 -"+serializedValues.toString());
		jobContext.put("employeeWithLeaveStatusPending", employeeWithLeaveStatusPending);
		return RepeatStatus.FINISHED;
	}

//	
//	@Bean
//	public Step extractEmpAndLeaveRef(PlatformTransactionManager transactionManager, 
//			JobRepository jobRepository,
//			FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending,
//			SpringBatchConfig springBatchConfig
//			) {
//		
//		System.out.println("inside extractEmpAndLeaveRef step");
//		return new StepBuilder("extractEmpAndLeaveRef", jobRepository)
//				.tasklet(LeavesDataExtractorForLeaveIdAndEmpRef(springBatchConfig ))
//				.transactionManager(transactionManager)
//				.build();
//	}
//	
//	private Tasklet LeavesDataExtractorForLeaveIdAndEmpRef(SpringBatchConfig springBatchConfig) {
//		return new Tasklet() {
//
//			@Override
//			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
////				ExecutionContext jobContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
//				System.out.println("inside LeavesDataExtractorForLeaveIdAndEmpRef Tasklet");
//				
//				String serializedValues = chunkContext.getStepContext().getStepExecution().getExecutionContext().getString("employeeWithLeaveStatusPending");
//		        ArrayList<fetchPendingStatusResponseList> chunkEmpLeaves = (ArrayList<fetchPendingStatusResponseList>) objectMapper.readValue(serializedValues, List.class);
//
//		        System.out.println("---- chunkEmpLeaves----" + chunkEmpLeaves.size());
//				
////				List<fetchPendingStatusResponseList> chunkEmpLeaves=empApplyLeaveSublist;
//				
////				List<fetchPendingStatusResponseList> chunkEmpLeaves=(List<fetchPendingStatusResponseList>) jobContext.get("empApplyLeaveSublist");
//				
//				for (int i = 0; i < chunkEmpLeaves.size(); i++) {
//					GetEmployeeSupervisorDetailsForEmailNotification(chunkEmpLeaves.get(i),springBatchConfig);
//				}
//
//				// some validation to check is task completed then send finished
//				return RepeatStatus.FINISHED;
//			}
//		};
//
//	}
//
//	@Bean
//	public Step extractSupervisorNotifiactionMail(PlatformTransactionManager transactionManager, 
//			JobRepository jobRepository,
//			FetchEmployeeApplyLeavePendingStatusResponseArray employeeWithLeaveStatusPending,
//			SpringBatchConfig springBatchConfig
//			) {
//		
//		System.out.println("inside extractSupervisorNotifiactionMail step");
//		return new StepBuilder("extractSupervisorNotifiactionMail", jobRepository)
//				.tasklet(GetEmployeeSupervisorDetailsForEmailNotification(employeeWithLeaveStatusPending,springBatchConfig ))
//				.transactionManager(transactionManager).build();
//	}
//	
//	private Tasklet GetEmployeeSupervisorDetailsForEmailNotification(fetchPendingStatusResponseList empLeaveRef, SpringBatchConfig springBatchConfig)
//	{
//		return new Tasklet() {
//
//			@Override
//			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//				System.out.println("inside GetEmployeeSupervisorDetailsForEmailNotification Tasklet");
//				
//				Long empId= Long.parseLong(empLeaveRef.getEmployeeReference().split("_")[1]);
//				CreateEmployeeResponse resp= idbImpl.getEmployeeByEmployeeId(empId);
//				
//				if(!resp.getSupervisor_Email().equals(null))
//				{
////					dto.getCreateEmployeeResponse().getSupervisor_Email();
//					leaveJobRunner.setCurrEmpLeaveDetails(empLeaveRef);
//					leaveJobRunner.setSupervisorMail(dto.getCreateEmployeeResponse().getSupervisor_Email());
//					
//					// need some validation after that pass return finished;
//					leaveJobRunner.setSpringBatchConfig(springBatchConfig);
//					leaveJobRunner.run();
//					return RepeatStatus.FINISHED;
//				}
//				return RepeatStatus.CONTINUABLE;
//			}
//		};
//	}
}
