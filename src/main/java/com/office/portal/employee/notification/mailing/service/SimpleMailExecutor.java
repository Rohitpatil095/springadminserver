package com.office.portal.employee.notification.mailing.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.office.portal.employee.notification.mailing.Mail;

import jakarta.mail.internet.MimeMessage;

public interface SimpleMailExecutor {
	String sendSimpleMail(Mail mail);
	String sendMailToMultipleUsers(List<String> empMails, Mail mail);
	void mimeLeaveMailNotification(MimeMessage message);
}
