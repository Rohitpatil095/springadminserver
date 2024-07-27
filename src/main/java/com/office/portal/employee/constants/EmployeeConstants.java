package com.office.portal.employee.constants;

public class EmployeeConstants {

	
	public static enum STATUS
	{
		SUCCESS,
		FAILURE
	}

	public static final String LEAVE_SERVICE_URL="http://localhost:";
	public static final String LEAVE_SERVICE_DEPLOYED_PORT="8080";
	public static final String LEAVE_SERVICE_V1="/leaves";
	public static final String LEAVE_SERVICE_QUALIFIED_URL_V1=LEAVE_SERVICE_URL+LEAVE_SERVICE_DEPLOYED_PORT+LEAVE_SERVICE_V1;
	public static final String LEAVE_SERVICE_URL_LEAVES_APPLYLEAVE="/leaves/applyleave";
	public static final String LEAVE_SERVICE_URL_LEAVES_GET_LEAVES_BY_LEAVE_ID="/leaves/getLeave";
	public static final String LEAVE_SERVICE_URL_BUILDER=LEAVE_SERVICE_URL+LEAVE_SERVICE_DEPLOYED_PORT;
	public static final String LEAVE_SERVICE_URL_NOTIFICATION_MAIL_SENDER="sendLeaveNotificationMail";
	public static final String LEAVE_COORELATION_KEY="354-sf65erg-7687-s64565df-432";
	public static final String LEAVE_APPROVAL_NOTIFICATION_MAIL_CONTEXT_FILE_PATH="leaveApprovalNotificationMail.html";
	public static final String LEAVE_SERVICE_GETALLLEAVES_WITH_PENDINGSTATUS= "applyleave/fetchPendingRecords";
}
