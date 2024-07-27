package com.office.portal.employee.batchchannel.jobs.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.office.portal.employee.batchchannel.jobs.ApplyLeaveJobRunner;
import com.office.portal.employee.batchchannel.jobs.LeaveNotificationStepFactory;
import com.office.portal.employee.businessservice.EmployeeBusinessService;
import com.office.portal.employee.businessservice.EmployeeApplyLeaveService;
import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.impl.EmployeeApplyLeave;
import com.office.portal.employee.infra.impl.IDBEmployeeImpl;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.FetchEmployeeApplyLeavePendingStatusResponseArray;

@Service
public class EmployeeApplyLeaveNotificationScheduler {
	
	private EmployeeApplyLeave employeeApplyLeave;
	private Dto dto;

	@Autowired
	private EmployeeApplyLeaveService employeeApplyLeaveService;

	@Autowired 
	private EmployeeBusinessService createEmployeeBusinessService;
	
	@Autowired
	private CreateEmployeeResponse createEmployeeResponse;
	
	@Autowired
	private LeaveNotificationStepFactory leaveNotificationJobFactory;
	
	@Autowired
	private IDBEmployeeImpl idbImpl;
	
//	@Autowired
//	private SpringBatchConfig springBatchConfig;
	
	@Autowired
	private ApplyLeaveJobRunner applyLeaveJobRunner;
	
	
//	@Autowired
//	private ApplyLeaveJobRunner applyLeaveJobRunner;
	
	@Autowired
	public EmployeeApplyLeaveNotificationScheduler(EmployeeApplyLeave employeeApplyLeave, Dto dto) {
		super();
		this.employeeApplyLeave = employeeApplyLeave;
		this.dto=dto;
	}
	
//	public Long[] getEmpIds(FetchEmployeeApplyLeavePendingStatusResponseArray employeeArrayWithLeaveStatusPending)
//	{
//		Long[] ids=new Long[employeeArrayWithLeaveStatusPending.getPendingStatusResponses().size()];
//		
//		for(int i=0;i<employeeArrayWithLeaveStatusPending.getPendingStatusResponses().size();i++)
//		{
//			ids[i]=Long.parseLong(employeeArrayWithLeaveStatusPending.getPendingStatusResponses().get(i).getEmployeeReference().split("_")[1]);
//			System.out.println("ids---- "+ids[i]);
//		}
//		return ids;
////		return employeeWithLeaveStatusPending.stream()
////				.map(emp -> emp.getEmployeeReference().split("_"))
////				.map(val-> Long.parseLong(val)).toArray(Long[]::new);
////	}
//	}
		
//	public String[] getSupervisorMailsUsingEmpId(Long[] ids)
//	{
//		String[] mails=new String[ids.length];
//		for(int i=0;i<ids.length;i++)
//		{			
//			idbImpl.getEmployeeByEmployeeId(ids[i]);
//			System.out.println("sup mail ---------"+dto.getCreateEmployeeResponse().getSupervisor_Email());
//			mails[i]=dto.getCreateEmployeeResponse().getSupervisor_Email();
//		}
//		return mails;
//	}
				
//	@Scheduled(cron = "0 0 10 1/1 * ? *")
	@Scheduled(cron = "0 0 10 * * *", zone = "US/Pacific")
	public  void sendLeaveNotificationExecutor()
	{
		dto = employeeApplyLeaveService.GetEmployeeApplyLeaveDetailsForPendingLeaveStatus("Pending", dto);
		applyLeaveJobRunner.run();
		System.out.println("executed scheduler");
		
		
//		return employeeWithLeaveStatusPending;
	
//		for(int i=0;i<employeeWithLeaveStatusPending.size();i++)
//		{
//			dto =employeeApplyLeaveService.GetAllLeaveDetailsUsingLeaveId(Long.parseLong(employeeWithLeaveIds.get(i)[1]) ,dto);
//			dto=employeeApplyLeaveService.GetEmployeeApplyLeaveDetailsForMailNotification(dto.getGetAllLeaveDetails().getLeaveId(), dto);
			// call leavenotification job factory which send mail
			
			// consumed leave api to get all emp applied for leaves
//			"/applyleave/fetchPendingRecords" ----> api return arraylist stored in employeeWithLeaveStatusPending
			
			// get supervisor email using emp id
		// ------------------ WORKING--------------------------
//			Long[] ids=getEmpIds(employeeWithLeaveStatusPending);
//			String [] supervisorMails= getSupervisorMailsUsingEmpId(ids);
//			
//			for(int i=0;i<supervisorMails.length;i++)
//			{
//				System.out.println(employeeWithLeaveStatusPending.getPendingStatusResponses().get(i));
//			}
//			springBatchConfig.leaveNotificationJobFactory();
//			applyLeaveJobRunner.run();
			// ----------------------------------------------
//			dto= createEmployeeBusinessService.getEmployeeByIdService(Long.parseLong(employeeWithLeaveIds.get(i)[0]), dto);
//			createEmployeeResponse= dto.getCreateEmployeeResponse();
//			if(createEmployeeResponse.getSupervisor_Email().equals(null))
//			{
//				// throw excepton
//			}
//			else
//			{
////				call job to send mail notification
//				applyLeaveJobRunner.run();
//			}
//		}
	}
}
