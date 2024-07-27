package com.office.portal.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.office.portal.employee.businessservice.EmployeeApplyLeaveService;
import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.request.EmployeeApplyLeaveRequest;
import com.office.portal.employee.infra.response.EmployeeApplyLeaveResponse;
import com.office.portal.employee.infra.response.GetAllLeaveDetails;
import com.office.portal.employee.infra.response.GetAllLeaveDetailsList;

@RestController
public class ExternalServicesConsumerController {

	@Autowired Dto dto;
	@Autowired EmployeeApplyLeaveService employeeApplyLeaveService;
	
	@PostMapping("/applyLeave")
	public EmployeeApplyLeaveResponse EmployeeApplyLeave(@RequestBody EmployeeApplyLeaveRequest employeeApplyLeaveRequest)
	{
		dto.setEmployeeApplyLeaveRequest(employeeApplyLeaveRequest);
		employeeApplyLeaveService.applyLeaveByEmployeeID(dto);
		return dto.getEmployeeApplyLeaveResponse();
	}

	
	@GetMapping("/notficiationGetleaveDetails/{id}")
	public EmployeeApplyLeaveResponse EmployeeApplyLeaveDetails(@PathVariable("id") Long leaveId)
	{
		employeeApplyLeaveService.applyLeaveByEmployeeID(dto);
		return dto.getEmployeeApplyLeaveResponse();
	}

	@PostMapping("/getLeaveDetails")
	public GetAllLeaveDetails getLeaveDetailsUsingLeaveId(@RequestBody String Status)
	{
		//employeeApplyLeaveService.GetAllLeaveDetailsUsingLeaveId(Status,dto);
		return dto.getGetAllLeaveDetails();
	}
	

	
	
}
