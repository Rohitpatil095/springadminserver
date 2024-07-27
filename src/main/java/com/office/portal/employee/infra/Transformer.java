package com.office.portal.employee.infra;

import org.springframework.stereotype.Component;

import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.domain.entity.Employee;
import com.office.portal.employee.infra.request.ExternalServiceEmployeeApplyLeaveRequest;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;
import com.office.portal.employee.infra.response.SetErrorGenericResponse;

@Component
public class Transformer {

	public Dto createEmployee(Dto dto)
	{
//		System.out.println("priting dto -----"+dto.getEmp().toString());
		Employee employee= new Employee();
		dto.setEmp(employee);
		
//		dto.getEmp().setEmployee_ref(dto.getCreateEmployeeRequest().getEmployee_Name()+);
		dto.getEmp().setAadharNo(dto.getCreateEmployeeRequest().getAadhar_No());
		dto.getEmp().setBloodGroup(dto.getCreateEmployeeRequest().getBlood_Group());
		dto.getEmp().setContact(dto.getCreateEmployeeRequest().getContact());
		dto.getEmp().setSecContact(dto.getCreateEmployeeRequest().getSec_Contact());
		dto.getEmp().setEmployeeAddress(dto.getCreateEmployeeRequest().getEmployee_Address());
		dto.getEmp().setEmployeeName(dto.getCreateEmployeeRequest().getEmployee_Name());
		dto.getEmp().setPanNo(dto.getCreateEmployeeRequest().getPan_No());
		dto.getEmp().setPassportNo(dto.getCreateEmployeeRequest().getPassport_No());
		dto.getEmp().setSupervisorEmail(dto.getCreateEmployeeRequest().getSupervisor_Email());
		dto.getEmp().setSupervisorName(dto.getCreateEmployeeRequest().getSupervisor_Name());
		dto.getEmp().setSupervisorEmpId(Long.parseLong(dto.getCreateEmployeeRequest().getSupervisor_EmpId()));
		
		return dto;
		
	}
	
	public Dto createEmployeeResponseTransformer(Dto dto, Boolean isSuperVisorDetailsPresent)
	{
		if(!isSuperVisorDetailsPresent) {
			SetErrorGenericResponse setErrorCreateEmployeeResponse=new SetErrorGenericResponse("Supervisor details not present");
			dto.setSetErrorCreateEmployeeResponse(setErrorCreateEmployeeResponse);
			return dto;
		}
		CreateEmployeeResponse createEmployeeResponse= new CreateEmployeeResponse();
		dto.setCreateEmployeeResponse(createEmployeeResponse);
		
		Employee emp= dto.getEmp();
		dto.setEmp(emp);
		
		System.out.println("------ "+ emp.toString());
		dto.getCreateEmployeeResponse().setEmployee_Name(emp.getEmployeeName());
		dto.getCreateEmployeeResponse().setEmployee_Id(emp.getEmployeeId());
		dto.getCreateEmployeeResponse().setSupervisor_Name(emp.getSupervisorName());
		dto.getCreateEmployeeResponse().setSupervisor_Email(emp.getSupervisorEmail());
		
		return dto;
		
	}
	
	public Dto transformEmployeeApplyLeaveRequestToExternalServiceEmployeeApplyLeaveRequest(Dto dto)
	{
		ExternalServiceEmployeeApplyLeaveRequest externalServiceEmployeeApplyLeaveRequest= new ExternalServiceEmployeeApplyLeaveRequest();
		dto.setExternalServiceEmployeeApplyLeaveRequest(externalServiceEmployeeApplyLeaveRequest);

		dto.getExternalServiceEmployeeApplyLeaveRequest().setEmployeeRef(dto.getEmployeeApplyLeaveRequest().getEmployeeName()+dto.getEmployeeApplyLeaveRequest().getId());
		dto.getExternalServiceEmployeeApplyLeaveRequest().setFromDate(dto.getEmployeeApplyLeaveRequest().getFromDate());
		dto.getExternalServiceEmployeeApplyLeaveRequest().setToDate(dto.getEmployeeApplyLeaveRequest().getToDate());
		dto.getExternalServiceEmployeeApplyLeaveRequest().setLeaveType(dto.getEmployeeApplyLeaveRequest().getLeaveType());
		dto.getExternalServiceEmployeeApplyLeaveRequest().setNumberOfLeaves(dto.getEmployeeApplyLeaveRequest().getNumberOfLeaves());
	
		return dto;
	}
	
//	public Dto transformEmpLeave2LeavePendingStatusDetails(Dto dto)
//	{
//		dto.getLeavePendingStatusDetails().setEmployeeReference(dto.getCreateEmployeeResponse().getEmployee_Id());
//		dto.getExternalServiceEmployeeApplyLeaveRequest().setFromDate(dto.);
//		dto.getExternalServiceEmployeeApplyLeaveRequest().setSupervisor_Name(dto.getEmp().getSupervisor_Name());
//		dto.getExternalServiceEmployeeApplyLeaveRequest().setSupervisor_Email(dto.getEmp().getSupervisor_Email());
//		dto.getExternalServiceEmployeeApplyLeaveRequest().setEmployeeRef(dto.getEmp().getEmpRef());
//		return dto;
//	}
}
