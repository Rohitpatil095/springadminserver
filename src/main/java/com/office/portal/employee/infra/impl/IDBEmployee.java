package com.office.portal.employee.infra.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.request.CreateEmployeeRequest;
import com.office.portal.employee.infra.response.CreateApplyLeaveEmployeeResponse;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;

@Service
public interface IDBEmployee {	
	
	//create
	public Dto createNewEmployee(Dto dto);
	
	//read
	public List<CreateEmployeeResponse> getAllEmployee();
	public CreateEmployeeResponse getEmployeeByEmployeeId(Long empId);
	public CreateEmployeeRequest getEmployeeBySupervisor_EmpId(Long Supervisor_EmpId);
	
	//update
	public CreateEmployeeResponse updateEmployee(Long empId, Dto dto);
	
	//delete
	public void deleteEmployee(Long empId);
	
	public CreateApplyLeaveEmployeeResponse getEmployeeUsingEmpRef(String empRef,Dto dto);
	
//	public List<int[]> employeeWatingForLeaveApproval();
}
