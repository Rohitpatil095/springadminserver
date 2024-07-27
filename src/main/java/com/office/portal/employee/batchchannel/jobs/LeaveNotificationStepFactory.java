package com.office.portal.employee.batchchannel.jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.office.portal.employee.batchchannel.jobs.schedulers.EmployeeApplyLeaveNotificationScheduler;
import com.office.portal.employee.businessservice.EmployeeBusinessService;
import com.office.portal.employee.businessservice.EmployeeApplyLeaveService;
import com.office.portal.employee.constants.EmployeeConstants;
import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.fetchPendingStatusResponseList;
import com.office.portal.employee.notification.mailing.Mail;
import com.office.portal.employee.notification.mailing.service.SimpleMailExecutor;

import jakarta.mail.internet.MimeMessage;

@Service
@StepScope
public class LeaveNotificationStepFactory implements Tasklet {

	@Autowired
	private EmployeeApplyLeaveService employeeApplyLeaveService;

	@Autowired
	private SimpleMailExecutor mailExecutor;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EmployeeBusinessService createEmployeeBusinessService;

	@Autowired
	private CreateEmployeeResponse createEmployeeResponse;

	@Autowired
	private Dto dto;

	@Autowired
	private Mail mail;

	private String contextTemplate= null;

	private MimeMessage message = null;
	private EmployeeApplyLeaveNotificationScheduler employeeApplyLeaveNotificationScheduler;

//------ REFACTOR BELOW CODE	

//	public Step leaveNotificationStepfactoryCreator(PlatformTransactionManager transactionManager,
//			JobRepository jobRepository,
//			String supervisorEmail,
//			fetchPendingStatusResponseList currEmpLeaveDetails )
//	{
//		System.out.println("inside leaveNotificationStepfactoryCreator Step");
//		return new StepBuilder("leaveNotificationStep", jobRepository)
//		.tasklet(mailContextReaderTasklet(dto,supervisorEmail,currEmpLeaveDetails))
////		.tasklet(FomatLeaveNotificationMailContextTasklet(contextTemplate,dto,currEmpLeaveDetails))
////		.tasklet(SetLeaveNotificationOverMailTasklet(dto,mail,supervisorEmail))
////		.tasklet(leaveNotifactionExecutorTask())
//		.transactionManager(transactionManager)
//		.build();
//	}

//	private Tasklet mailContextReaderTasklet(Dto dto,String supervisorEmail,
//			fetchPendingStatusResponseList currEmpLeaveDetails)
//	{
//		return new Tasklet() {
//			
//			@Override
//			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//				System.out.println("inside mailContextReaderTasklet Tasklet");
//				Path path= Paths.get(EmployeeConstants.LEAVE_APPROVAL_NOTIFICATION_MAIL_CONTEXT_FILE_PATH);
//
//				try 
//				{
//					contextTemplate = Files.readString(path);
//					if(contextTemplate.isEmpty())
//					{
//						// raise some exception 
//						System.out.println("exception due to contextTemplate is empty - from");
//					}	
//					
//					htmlContentFormated=contextTemplate.replace("{empRef}",currEmpLeaveDetails.getEmployeeReference());
//					htmlContentFormated.replace("{leaveFrom}",currEmpLeaveDetails.getFromDate().toString());
//					htmlContentFormated.replace("{leaveTo}",currEmpLeaveDetails.getToDate().toString());
//					htmlContentFormated.replace("{leaveId}",currEmpLeaveDetails.getLeaveId());
//					
//					System.out.println("inside SetLeaveNotificationOverMailTasklet Tasklet");
//					message =mailSender.createMimeMessage();
////					mail.setSubject("Leave Approval Pending Status for Empid- " + + "and LeaveId- "+ );
//					mail.setSubject("Leave Approval Pending Status Notification Mail");
//					mail.setMessage(htmlContentFormated);
//					
//					try {
//						message.setFrom(mail.getFrom());
//						message.setRecipients(MimeMessage.RecipientType.TO,supervisorEmail);
//						message.setContent(mail.getMessage(),"text/html; charset=utf-8");
//						message.setSubject(mail.getSubject());
//						mailExecutor.mimeLeaveMailNotification(message);
//						
//					} catch (MessagingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					System.out.println("inside leaveNotifactionExecutorTask Tasklet");
//					mailSender.send(message);
//					
//					if(!htmlContentFormated.isEmpty() && message.getAllRecipients().length!=0)
//					{
//						return RepeatStatus.FINISHED;
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//				return RepeatStatus.FINISHED;
//			}
//		};
//	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("inside mailContextReaderTasklet Tasklet");
		String htmlContentFilePath = EmployeeConstants.LEAVE_APPROVAL_NOTIFICATION_MAIL_CONTEXT_FILE_PATH;

		ArrayList<CreateEmployeeResponse> empRefResponseContextData = (ArrayList<CreateEmployeeResponse>)  chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("employeeRefDetails");

		empRefResponseContextData.stream().forEach(item -> System.out.println(item.toString()));
		List<fetchPendingStatusResponseList>  empLeaveStatusPendingContextData = (List<fetchPendingStatusResponseList>) chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("employeeWithLeaveStatusPending");
		BufferedReader reader =null;
		try {
			File file = ResourceUtils.getFile("classpath:" +htmlContentFilePath);
			reader= new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));

			contextTemplate = reader.lines().collect(Collectors.joining(System.lineSeparator()));
//			System.out.println(contextTemplate);
//			contextTemplate = Files.readString(path);
			if (contextTemplate.isEmpty()) {
				// raise some exception
				System.out.println("exception due to contextTemplate is empty - from");
			}
//		System.out.println(path);
//		System.out.println(contextTemplate.toString());
//			return RepeatStatus.FINISHED;
//
			for (int htmlMailContentFormater = 0; htmlMailContentFormater < empLeaveStatusPendingContextData
					.size(); htmlMailContentFormater++) {
				
				contextTemplate=contextTemplate.replace("{empRef}",
						empRefResponseContextData.get(htmlMailContentFormater).getEmployee_Id().toString());
				
				contextTemplate=contextTemplate.replace("{leaveFrom}", empLeaveStatusPendingContextData.get(htmlMailContentFormater)
						.getFromDate().toString());
				contextTemplate=contextTemplate.replace("{leaveTo}", empLeaveStatusPendingContextData.get(htmlMailContentFormater)
						.getToDate().toString());
				contextTemplate=contextTemplate.replace("{leaveId}", empLeaveStatusPendingContextData.get(htmlMailContentFormater)
						.getLeaveId().toString());

				message = mailSender.createMimeMessage();
				mail.setSubject("Leave Approval Pending Status Notification Mail");
				mail.setMessage(contextTemplate);

				message.setFrom(mail.getFrom());
				message.setRecipients(MimeMessage.RecipientType.TO,
						empRefResponseContextData.get(htmlMailContentFormater).getSupervisor_Email());
				message.setContent(mail.getMessage(), "text/html; charset=utf-8");
				message.setSubject(mail.getSubject());
				mailExecutor.mimeLeaveMailNotification(message);

				mailSender.send(message);

				if (!contextTemplate.isEmpty() && message.getAllRecipients().length != 0) {
					return RepeatStatus.FINISHED;
				}
				//break;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			reader.close();
		}

		return RepeatStatus.CONTINUABLE;
	}

	/*
	 * 
	 * private Tasklet FomatLeaveNotificationMailContextTasklet(String
	 * contextTemplate,Dto dto,fetchPendingStatusResponseList currEmpLeaveDetails) {
	 * return new Tasklet() {
	 * 
	 * @Override public RepeatStatus execute(StepContribution contribution,
	 * ChunkContext chunkContext) throws Exception {
	 * System.out.println("inside FomatLeaveNotificationMailContextTasklet Tasklet"
	 * );
	 * htmlContentFormated=contextTemplate.replace("{empRef}",currEmpLeaveDetails.
	 * getEmployeeReference());
	 * htmlContentFormated.replace("{leaveFrom}",currEmpLeaveDetails.getFromDate().
	 * toString());
	 * htmlContentFormated.replace("{leaveTo}",currEmpLeaveDetails.getToDate().
	 * toString());
	 * htmlContentFormated.replace("{leaveId}",currEmpLeaveDetails.getLeaveId());
	 * 
	 * 
	 * if(!htmlContentFormated.isEmpty()) { return RepeatStatus.FINISHED; } return
	 * RepeatStatus.CONTINUABLE; } }; }
	 * 
	 * private Tasklet SetLeaveNotificationOverMailTasklet(Dto dto, Mail mail,String
	 * supervisorEmail) { return new Tasklet() {
	 * 
	 * @Override public RepeatStatus execute(StepContribution contribution,
	 * ChunkContext chunkContext) throws Exception {
	 * System.out.println("inside SetLeaveNotificationOverMailTasklet Tasklet");
	 * message =mailSender.createMimeMessage(); //
	 * mail.setSubject("Leave Approval Pending Status for Empid- " + +
	 * "and LeaveId- "+ );
	 * mail.setSubject("Leave Approval Pending Status Notification Mail");
	 * mail.setMessage(htmlContentFormated);
	 * 
	 * try { message.setFrom(mail.getFrom());
	 * message.setRecipients(MimeMessage.RecipientType.TO,supervisorEmail);
	 * message.setContent(mail.getMessage(),"text/html; charset=utf-8");
	 * message.setSubject(mail.getSubject());
	 * mailExecutor.mimeLeaveMailNotification(message);
	 * 
	 * } catch (MessagingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * if(message.getAllRecipients().length!=0) { return RepeatStatus.FINISHED; } //
	 * need some proper exception handling mechanism return
	 * RepeatStatus.CONTINUABLE; } }; }
	 * 
	 * private Tasklet leaveNotifactionExecutorTask() { return new Tasklet() {
	 * 
	 * @Override public RepeatStatus execute(StepContribution contribution,
	 * ChunkContext chunkContext) throws Exception {
	 * System.out.println("inside leaveNotifactionExecutorTask Tasklet");
	 * mailSender.send(message); return RepeatStatus.FINISHED; } }; }
	 */

// thinks so not req. implement this logic in employee getLeaves side
//	private boolean isMailApprovalInPendingStateValidatorTasklet(Dto dto)
//	{
//		return true;
//	}

	private boolean isSenderInCompaniesWhiteListedMailsaTasklet() {
		return true;
	}

	private boolean validateReceiverDomainTasklet() {
		return true;
	}

	private Step spfEvaluationTasklet() {
		// implement dnslookup,verify is mail send by comp/dns whitelisted ip, etc...
		return null;
	}

}
