package com.office.portal.employee.infra.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.domain.entity.Employee;
import com.office.portal.employee.infra.Transformer;
import com.office.portal.employee.infra.repository.EmployeeRepository;
import com.office.portal.employee.infra.request.CreateEmployeeRequest;
import com.office.portal.employee.infra.response.CreateApplyLeaveEmployeeResponse;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;

@Service
public class IDBEmployeeImpl implements IDBEmployee{
	
	private EmployeeRepository employeeRepo;
	private Dto dto;
	private Transformer transformer;

	@Autowired
	public IDBEmployeeImpl(EmployeeRepository employeeRepo, Dto dto, Transformer transformer) {
		super();
		this.employeeRepo = employeeRepo;
		this.dto = dto;
		this.transformer=transformer;
	}

	@Override
	public Dto createNewEmployee(Dto dto) {
		Employee newEmployee= dto.getEmp();
//		System.out.println("----------"+newEmployee.toString());
		newEmployee =employeeRepo.save(newEmployee);
		newEmployee.setEmpRef( newEmployee.getEmployeeName().replace(" ", "-") + "_" +newEmployee.getEmployeeId());
		employeeRepo.save(newEmployee);
		return dto;
	}

	@Override
	public List<CreateEmployeeResponse> getAllEmployee() {
		return null; // employeeRepo.findAll();
	}

	@Override
	public CreateEmployeeResponse getEmployeeByEmployeeId(Long empId) {
		dto.setEmp(employeeRepo.findById(empId).get());
//		System.out.println(dto.getEmp().toString());
		if(dto.getEmp().getSupervisorEmail()!=null)
		{
			transformer.createEmployeeResponseTransformer(dto, true);
		}
//		else
//		{
			// throw exception 
//			dto.getSetErrorCreateEmployeeResponse();
//		}
		return dto.getCreateEmployeeResponse();
	}

	@Override
	public CreateEmployeeRequest getEmployeeBySupervisor_EmpId(Long Supervisor_EmpId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateEmployeeResponse updateEmployee(Long empId, Dto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CreateApplyLeaveEmployeeResponse getEmployeeUsingEmpRef(String empRef, Dto dto) {

		CreateApplyLeaveEmployeeResponse empResp= employeeRepo.getEmpUsingEmpRef(empRef);
		if(empRef.isBlank())
		{
//			thorw exception
		}
		dto.setCreateApplyLeaveEmployeeResponse(empResp);
		return dto.getCreateApplyLeaveEmployeeResponse();
	}

//	@Override
//	public List<int[]> employeeWatingForLeaveApproval() {
//		List<int[]> emp=employeeRepo.getEmpListPendingForLeaveApproval();
//		return emp;
//		{[35,7],[2,3]}
//		emp.stream()
//			.map(empl -> empl[0]!=0 && empl[1]!=0
//			).forEach(
//					
//					
//					 );	;
		
//	}
	

}
