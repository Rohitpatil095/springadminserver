package com.office.portal.employee.businessservice;

import org.springframework.stereotype.Service;

import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.request.CreateEmployeeRequest;

@Service
public class BusinessService {
	
	public boolean isEmployeeSupervisorDetailsPresent(Dto dto)
	{
		CreateEmployeeRequest emp=dto.getCreateEmployeeRequest();
		if(emp.getSupervisor_Email().equals(null)
				&& emp.getSupervisor_Email().isEmpty()
				&& emp.getSupervisor_EmpId().equals(null) 
				&& emp.getSupervisor_Name().equals(null)
				&& emp.getSupervisor_Name().isEmpty())
		{
			System.out.println(emp.getSupervisor_Email().equals(null) +" --" +  emp.getSupervisor_EmpId().equals(null));
			return false;
		}
		return true;
	}
	

}
