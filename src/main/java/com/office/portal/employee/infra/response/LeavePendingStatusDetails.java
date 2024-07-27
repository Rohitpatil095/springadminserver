package com.office.portal.employee.infra.response;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class LeavePendingStatusDetails {
	
    String employeeReference;
    String leaveId; 
    String status;
    LocalDate fromDate;
    LocalDate toDate;
    String empSupervisorId;
    
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
	public String getEmpSupervisorId() {
		return empSupervisorId;
	}
	public void setEmpSupervisorId(String empSupervisorId) {
		this.empSupervisorId = empSupervisorId;
	}
	@Override
	public String toString() {
		return "LeavePendingStatusDetails [employeeReference=" + employeeReference + ", leaveId=" + leaveId
				+ ", status=" + status + ", fromDate=" + fromDate + ", toDate=" + toDate + ", empSupervisorId="
				+ empSupervisorId + "]";
	}
	

    
    
}
