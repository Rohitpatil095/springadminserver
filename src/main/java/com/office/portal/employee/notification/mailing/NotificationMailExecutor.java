package com.office.portal.employee.notification.mailing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.office.portal.employee.constants.EmployeeConstants;
import com.office.portal.employee.constants.EmployeeConstants.STATUS;
import com.office.portal.employee.notification.mailing.service.MailExectorServiceImpl;

public class NotificationMailExecutor {
	
	@Autowired
	MailExectorServiceImpl exe;
	
    public STATUS sendNotificationMail(@RequestBody Mail mail)
    {
        String status
            = exe.sendSimpleMail(mail);
        System.out.println(status);
        return EmployeeConstants.STATUS.SUCCESS;
    }

}
