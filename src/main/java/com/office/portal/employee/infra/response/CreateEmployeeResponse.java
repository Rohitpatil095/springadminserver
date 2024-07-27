package com.office.portal.employee.infra.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class CreateEmployeeResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	Long employee_Id;
	String employee_Name;
	String supervisor_Name;
	String supervisor_Email;
	
	public Long getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(Long employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getEmployee_Name() {
		return employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}
	public String getSupervisor_Name() {
		return supervisor_Name;
	}
	public void setSupervisor_Name(String supervisor_Name) {
		this.supervisor_Name = supervisor_Name;
	}
	public String getSupervisor_Email() {
		return supervisor_Email;
	}
	public void setSupervisor_Email(String supervisor_Email) {
		this.supervisor_Email = supervisor_Email;
	}	
}
