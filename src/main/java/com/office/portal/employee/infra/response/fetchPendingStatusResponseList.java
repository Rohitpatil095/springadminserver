package com.office.portal.employee.infra.response;

import java.io.Serializable;
import java.time.LocalDate;

public class fetchPendingStatusResponseList implements Serializable {
	
    String employeeReference;
    String leaveId; 
    String status;
    LocalDate fromDate;
    LocalDate toDate;
    
	public String getEmployeeReference() {
		return employeeReference;
	}
	public void setEmployeeReference(String employeeReference) {
		this.employeeReference = employeeReference;
	}
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public fetchPendingStatusResponseList(String employeeReference, String leaveId, String status,
			LocalDate fromDate, LocalDate toDate) {
		super();
		this.employeeReference = employeeReference;
		this.leaveId = leaveId;
		this.status = status;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
    
    

}
