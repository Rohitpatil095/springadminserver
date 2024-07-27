package com.office.portal.employee.infra.response;

import java.time.LocalDate;

public class GetAllLeaveDetails {

	private LocalDate appliedLeaveFrom;
	private LocalDate appliedLeaveTo;
	private String appliedLeaveType;
	private String employeeRefrence;
	private Long leaveId;
	
	
	public LocalDate getAppliedLeaveFrom() {
		return appliedLeaveFrom;
	}
	public void setAppliedLeaveFrom(LocalDate appliedLeaveFrom) {
		this.appliedLeaveFrom = appliedLeaveFrom;
	}
	public LocalDate getAppliedLeaveTo() {
		return appliedLeaveTo;
	}
	public void setAppliedLeaveTo(LocalDate appliedLeaveTo) {
		this.appliedLeaveTo = appliedLeaveTo;
	}
	public String getAppliedLeaveType() {
		return appliedLeaveType;
	}
	public void setAppliedLeaveType(String appliedLeaveType) {
		this.appliedLeaveType = appliedLeaveType;
	}
	public String getEmployeeRefrence() {
		return employeeRefrence;
	}
	public void setEmployeeRefrence(String employeeRefrence) {
		this.employeeRefrence = employeeRefrence;
	}
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

}
