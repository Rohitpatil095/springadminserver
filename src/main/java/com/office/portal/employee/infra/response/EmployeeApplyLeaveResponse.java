package com.office.portal.employee.infra.response;

import org.springframework.stereotype.Component;

@Component
public class EmployeeApplyLeaveResponse {
	
	private String empRef;
	private String leaveId;
	private String leaveStauts;
	
	
	public String getEmpRef() {
		return empRef;
	}
	public void setEmpRef(String empRef) {
		this.empRef = empRef;
	}
	public String getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveStauts() {
		return leaveStauts;
	}
	public void setLeaveStauts(String leaveStauts) {
		this.leaveStauts = leaveStauts;
	}
	
	

}
