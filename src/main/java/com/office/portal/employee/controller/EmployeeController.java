package com.office.portal.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.office.portal.employee.businessservice.EmployeeBusinessService;
import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.request.CreateEmployeeRequest;
import com.office.portal.employee.infra.request.EmployeeByEmpRef;
import com.office.portal.employee.infra.response.CreateApplyLeaveEmployeeResponse;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.GetAllLeaveDetailsList;

@RestController
public class EmployeeController {
	
	private EmployeeBusinessService createEmployeeBusinessService;
	private Dto dto;
	
	@Autowired
	public EmployeeController(EmployeeBusinessService svc,Dto dto) {
		super();
		this.createEmployeeBusinessService = svc;
		this.dto =dto;
	}


	@PostMapping("/employee")
	public CreateEmployeeResponse createNewEmployee(@RequestBody CreateEmployeeRequest Employee)
	{
		dto.setCreateEmployeeRequest(Employee);
		createEmployeeBusinessService.createEmployeeService(dto);
		return dto.getCreateEmployeeResponse();
	}
	
	@GetMapping("/getAllEmployees")
	public List<CreateEmployeeResponse> getAllEmployee(){
		return null;
	}
	
	@GetMapping("/getEmployeeByEmployeeId/{id}")
	public CreateEmployeeResponse getEmployeeByEmployeeId(@PathVariable("id") Long id){
		createEmployeeBusinessService.getEmployeeByIdService(id, dto);
		return dto.getCreateEmployeeResponse();
	}
	
	@PostMapping("/getEmployeeByEmployeeRef")
	public CreateApplyLeaveEmployeeResponse getEmployeeByEmployeeRef(@RequestBody EmployeeByEmpRef empRef){
		if(empRef.getEmpRef().isBlank())
		{
//			throw custome exception;
		}
		
		createEmployeeBusinessService.getEmployeeByEmpRefrenceService(empRef.getEmpRef(), dto);
		return dto.getCreateApplyLeaveEmployeeResponse();
	}
	
	@GetMapping("/getleave")
	public GetAllLeaveDetailsList getDetails()
	{
		System.out.println("sof");
//		GetAllLeaveDetailsList getAllLeaveDetailsList = new GetAllLeaveDetailsList();
//		RestTemplate restTemplate = new RestTemplate();
//		
//		GetAllLeaveDetailsList getAllLeaveDetailsList1 = restTemplate.postForObject("http://localhost:8080/leaves/applyleave/fetchPendingRecords",
//				"Pending", GetAllLeaveDetailsList.class);
		return null;
	}
	
	
}
