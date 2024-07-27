package com.office.portal.employee.infra.impl;

import java.util.List;

import com.office.portal.employee.domain.dto.Dto;

public interface EmployeeApplyLeave {
	
	public Dto createNewEmployeeLeaveApplyRequest(Dto dto);
	public List<String[]> getAllEmployeeIdsWithLeaveStatusAsPending();

}
