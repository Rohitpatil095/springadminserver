package com.office.portal.employee.domain.dto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.office.portal.employee.domain.entity.Employee;
import com.office.portal.employee.domain.entity.EmployeeLeave;
import com.office.portal.employee.infra.request.CreateEmployeeRequest;
import com.office.portal.employee.infra.request.EmployeeApplyLeaveRequest;
import com.office.portal.employee.infra.request.ExternalServiceEmployeeApplyLeaveRequest;
import com.office.portal.employee.infra.response.CreateApplyLeaveEmployeeResponse;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.fetchPendingStatusResponseList;
import com.office.portal.employee.infra.response.EmployeeApplyLeaveResponse;
import com.office.portal.employee.infra.response.FetchEmployeeApplyLeavePendingStatusResponseArray;
import com.office.portal.employee.infra.response.GetAllLeaveDetails;
import com.office.portal.employee.infra.response.LeavePendingStatusDetails;
import com.office.portal.employee.infra.response.SetErrorGenericResponse;

@Component
public class Dto {
	
	private CreateEmployeeRequest createEmployeeRequest;
	@Autowired private CreateEmployeeResponse createEmployeeResponse;
	private Employee emp;
	private EmployeeApplyLeaveResponse employeeApplyLeaveResponse;
	private EmployeeApplyLeaveRequest employeeApplyLeaveRequest;
	private EmployeeLeave employeeLeave;
	private ExternalServiceEmployeeApplyLeaveRequest externalServiceEmployeeApplyLeaveRequest;
	private SetErrorGenericResponse setErrorCreateEmployeeResponse;
	private GetAllLeaveDetails getAllLeaveDetails;
	private FetchEmployeeApplyLeavePendingStatusResponseArray fetchEmployeeApplyLeavePendingStatusResponseArray;
	@Autowired private CreateApplyLeaveEmployeeResponse createApplyLeaveEmployeeResponse;
	@Autowired private LeavePendingStatusDetails leavePendingStatusDetails;
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public CreateEmployeeRequest getCreateEmployeeRequest() {
		return createEmployeeRequest;
	}
	
	public void setCreateEmployeeRequest(CreateEmployeeRequest createEmployeeRequest) {
		this.createEmployeeRequest = createEmployeeRequest;
	}
	
	public CreateEmployeeResponse getCreateEmployeeResponse() {
		return createEmployeeResponse;
	}
	
	public void setCreateEmployeeResponse(CreateEmployeeResponse createEmployeeResponse) {
		this.createEmployeeResponse = createEmployeeResponse;
	}

	public EmployeeApplyLeaveResponse getEmployeeApplyLeaveResponse() {
		return employeeApplyLeaveResponse;
	}

	public void setEmployeeApplyLeaveResponse(EmployeeApplyLeaveResponse employeeApplyLeaveResponse) {
		this.employeeApplyLeaveResponse = employeeApplyLeaveResponse;
	}

	public EmployeeApplyLeaveRequest getEmployeeApplyLeaveRequest() {
		return employeeApplyLeaveRequest;
	}

	public void setEmployeeApplyLeaveRequest(EmployeeApplyLeaveRequest employeeApplyLeaveRequest) {
		this.employeeApplyLeaveRequest = employeeApplyLeaveRequest;
	}

	public EmployeeLeave getEmployeeLeave() {
		return employeeLeave;
	}

	public void setEmployeeLeave(EmployeeLeave employeeLeave) {
		this.employeeLeave = employeeLeave;
	}

	public ExternalServiceEmployeeApplyLeaveRequest getExternalServiceEmployeeApplyLeaveRequest() {
		return externalServiceEmployeeApplyLeaveRequest;
	}

	public void setExternalServiceEmployeeApplyLeaveRequest(
			ExternalServiceEmployeeApplyLeaveRequest externalServiceEmployeeApplyLeaveRequest) {
		this.externalServiceEmployeeApplyLeaveRequest = externalServiceEmployeeApplyLeaveRequest;
	}

	public SetErrorGenericResponse getSetErrorCreateEmployeeResponse() {
		return setErrorCreateEmployeeResponse;
	}

	public void setSetErrorCreateEmployeeResponse(SetErrorGenericResponse setErrorCreateEmployeeResponse) {
		this.setErrorCreateEmployeeResponse = setErrorCreateEmployeeResponse;
	}

	public GetAllLeaveDetails getGetAllLeaveDetails() {
		return getAllLeaveDetails;
	}

	public void setGetAllLeaveDetails(GetAllLeaveDetails getAllLeaveDetails) {
		this.getAllLeaveDetails = getAllLeaveDetails;
	}

	public FetchEmployeeApplyLeavePendingStatusResponseArray getFetchEmployeeApplyLeavePendingStatusResponseArray() {
		return fetchEmployeeApplyLeavePendingStatusResponseArray;
	}

	public void setFetchEmployeeApplyLeavePendingStatusResponseArray(
			FetchEmployeeApplyLeavePendingStatusResponseArray fetchEmployeeApplyLeavePendingStatusResponseArray) {
		this.fetchEmployeeApplyLeavePendingStatusResponseArray = fetchEmployeeApplyLeavePendingStatusResponseArray;
	}

	public LeavePendingStatusDetails getLeavePendingStatusDetails() {
		return leavePendingStatusDetails;
	}

	public void setLeavePendingStatusDetails(LeavePendingStatusDetails leavePendingStatusDetails) {
		this.leavePendingStatusDetails = leavePendingStatusDetails;
	}

	public CreateApplyLeaveEmployeeResponse getCreateApplyLeaveEmployeeResponse() {
		return createApplyLeaveEmployeeResponse;
	}

	public void setCreateApplyLeaveEmployeeResponse(CreateApplyLeaveEmployeeResponse createApplyLeaveEmployeeResponse) {
		this.createApplyLeaveEmployeeResponse = createApplyLeaveEmployeeResponse;
	}
	
}
