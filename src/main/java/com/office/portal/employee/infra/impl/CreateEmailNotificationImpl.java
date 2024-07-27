package com.office.portal.employee.infra.impl;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.config.Task;

import com.office.portal.employee.notification.mailing.Mail;

public class CreateEmailNotificationImpl implements CreateEmailNotification {

	public Task sendNotificationMail(Mail mail) {
		HttpHeaders header= new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
//		HttpEntity<Employee>
		return null;
	}

}
