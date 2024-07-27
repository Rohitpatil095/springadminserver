package com.office.portal.employee.infra.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateApplyLeaveEmployeeResponse {

	Long employeeId;
	String employeeName;
	Long contact;
	Long secContact;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public Long getSecContact() {
		return secContact;
	}
	public void setSecContact(Long secContact) {
		this.secContact = secContact;
	}
	
//	@Autowired
	public CreateApplyLeaveEmployeeResponse(Long employeeId, String employeeName, Long contact, Long secContact) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.contact = contact;
		this.secContact = secContact;
	}
	public CreateApplyLeaveEmployeeResponse() {
		super();
	}
	@Override
	public String toString() {
		return "CreateApplyLeaveEmployeeResponse [employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", contact=" + contact + ", secContact=" + secContact + "]";
	}
	
	
	
}
