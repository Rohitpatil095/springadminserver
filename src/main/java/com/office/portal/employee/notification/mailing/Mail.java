package com.office.portal.employee.notification.mailing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mail {
	
	String subject;
	
	String message;
	
	@Value("{spring.mail.username}")
	static String from;
	
	public String getSubject()
	{
		return this.subject;
	}
	
	public String getMessage()
	{
		return this.message;
	}
	
	public Mail setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public Mail setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getFrom() {
		return from;
	}

	@Override
	public String toString() {
		return "Mail [subject=" + subject + ", message=" + message + ", from=" + from + "]";
	}
		
}
	
