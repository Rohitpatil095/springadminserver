package com.office.portal.employee.infra.request;

import java.time.LocalDate;

public class EmployeeApplyLeaveRequest {
	Long id;
	String employeeName;
//    String employeeRef;
    String leaveType;
    float numberOfLeaves;
    LocalDate fromDate;
    LocalDate toDate;

    
    public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getId() {
		return id;
	}
	//	public String getEmployeeRef() {
//		return employeeRef;
//	}
//	public void setEmployeeRef(String employeeRef) {
//		this.employeeRef = employeeRef;
//	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public float getNumberOfLeaves() {
		return numberOfLeaves;
	}
	public void setNumberOfLeaves(float numberOfLeaves) {
		this.numberOfLeaves = numberOfLeaves;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
}
