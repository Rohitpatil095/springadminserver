package com.office.portal.employee.notification.mailing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.office.portal.employee.constants.EmployeeConstants;
import com.office.portal.employee.notification.mailing.Mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailExectorServiceImpl implements SimpleMailExecutor{

	@Autowired
	private JavaMailSender mailSender;

	public SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

//	@Autowired
//	public MailExectorServiceImpl(JavaMailSender mailSender,SimpleMailMessage simpleMailMessage,MimeMessage mimeMessage) {
//		super();
//		this.mailSender = mailSender;
//		this.simpleMailMessage= simpleMailMessage;
//		this.mimeMessage=mimeMessage;
//	}
//	
//	
	
	public String sendSimpleMail(Mail mail) {
		try {
						
			simpleMailMessage.setFrom(mail.getFrom());
			simpleMailMessage.setTo("somemail@gmail.com");
			simpleMailMessage.setText(mail.getMessage());
			simpleMailMessage.setSubject(mail.getSubject());
			
			mailSender.send(simpleMailMessage);
			return String.valueOf(EmployeeConstants.STATUS.SUCCESS);
		}
		catch (Exception e) {
			System.out.println("excep-------"+ e );
		}
		return String.valueOf(EmployeeConstants.STATUS.FAILURE);
		
	}

	@Override
	public String sendMailToMultipleUsers(List<String> empMails, Mail mail) {
		
		simpleMailMessage.setFrom(mail.getFrom());
		simpleMailMessage.setTo(empMails.stream().toArray(String[]::new));
		simpleMailMessage.setText(mail.getMessage());
		simpleMailMessage.setSubject(mail.getSubject());

		mailSender.send(simpleMailMessage);
		return String.valueOf(EmployeeConstants.STATUS.SUCCESS);
	}

	@Override
	public void mimeLeaveMailNotification(MimeMessage message) {
		mailSender.send(message);
	}
}
