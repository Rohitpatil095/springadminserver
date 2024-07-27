package com.office.portal.employee.infra.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.domain.entity.EmployeeLeave;
import com.office.portal.employee.infra.repository.EmployeeApplyLeaveRepository;

@Service
public class EmployeeApplyLeaveImpl implements EmployeeApplyLeave {

	@Autowired private EmployeeApplyLeaveRepository employeeApplyLeaveRepository;
	
	@Override
	public Dto createNewEmployeeLeaveApplyRequest(Dto dto) {
		EmployeeLeave leave= dto.getEmployeeLeave();
		employeeApplyLeaveRepository.save(leave);
		return dto;
	}

	@Override
	public List<String[]> getAllEmployeeIdsWithLeaveStatusAsPending() {
		return employeeApplyLeaveRepository.getAllEmployeeIdsWithLeaveStatusAsPending();
	}

}
