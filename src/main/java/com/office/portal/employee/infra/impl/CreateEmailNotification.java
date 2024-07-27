package com.office.portal.employee.infra.impl;

import org.springframework.scheduling.config.Task;

import com.office.portal.employee.notification.mailing.Mail;

public interface CreateEmailNotification {

	public Task sendNotificationMail(Mail mail);
}
