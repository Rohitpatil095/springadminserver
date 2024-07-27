package com.office.portal.employee.businessservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.portal.employee.domain.dto.Dto;
import com.office.portal.employee.infra.Transformer;
import com.office.portal.employee.infra.impl.IDBEmployee;
import com.office.portal.employee.infra.response.CreateApplyLeaveEmployeeResponse;
import com.office.portal.employee.infra.response.CreateEmployeeResponse;

@Service
public class EmployeeBusinessService {
	private BusinessService businessService;
	private IDBEmployee idbemployee;
	private Transformer transformer;
	private CreateEmployeeResponse createEmployeeResponse;

	@Autowired
	public EmployeeBusinessService(BusinessService businessService, IDBEmployee idbemployee,
			Transformer transformer, CreateEmployeeResponse createEmployeeResponse) {
		super();
		this.businessService = businessService;
		this.idbemployee = idbemployee;
		this.transformer = transformer;
		this.createEmployeeResponse = createEmployeeResponse;
	}

	private boolean isEmployeeWithSameAaddharNoPresent() {
		// external api hit to validate aadhar no
		// implement later
		return true;
	}

	private boolean isEmployeeWithSamePanNoPresent() {
		return true;
	}

	private boolean isEmployeeWithSamePassportNoPresent() {
		return true;
	}

	private boolean isEmployeePassportNoValid() {
		return true;
	}

	private boolean isEmployeeAadharNoValid() {
		return true;
	}

	private boolean isEmployeePanNoValid() {
		return true;
	}

	public Dto createEmployeeService(Dto dto) {
		boolean checkIsSupervisorDetailsPresent = businessService.isEmployeeSupervisorDetailsPresent(dto);

		if (!checkIsSupervisorDetailsPresent) {
			transformer.createEmployeeResponseTransformer(dto, checkIsSupervisorDetailsPresent);
			return dto;
		}
		dto = transformer.createEmployee(dto);

		idbemployee.createNewEmployee(dto);
		transformer.createEmployeeResponseTransformer(dto, checkIsSupervisorDetailsPresent);
//		transformer.createEmployeeResponse(dto);
		return dto;
	}

//	public Dto getAllEmployee(Dto dto)
//	{
//		
//	}

	public Dto getEmployeeByIdService(Long id, Dto dto) {
		createEmployeeResponse = idbemployee.getEmployeeByEmployeeId(id);
		if (createEmployeeResponse.getEmployee_Name().equals(null)) {
			createEmployeeResponse.setEmployee_Id(0000l);
			createEmployeeResponse.setEmployee_Name("default");
			createEmployeeResponse.setSupervisor_Email("default@abc.com");
			createEmployeeResponse.setSupervisor_Name("defautl-abc");
			dto.setCreateEmployeeResponse(createEmployeeResponse);
		}
		dto.setCreateEmployeeResponse(createEmployeeResponse);
		return dto;
	}

	public Dto getEmployeeByEmpRefrenceService(String empRef, Dto dto) {
		CreateApplyLeaveEmployeeResponse resp= idbemployee.getEmployeeUsingEmpRef(empRef,dto);
		System.out.println("----->>>" +"empref"+empRef + " resp->" + idbemployee.getEmployeeUsingEmpRef(empRef,dto));
		System.out.println("---------"+resp.toString());
		
//		dto.setCreateApplyLeaveEmployeeResponse(new CreateApplyLeaveEmployeeResponse());
		dto.setCreateApplyLeaveEmployeeResponse(resp);
		System.out.println("============"+ dto.getCreateApplyLeaveEmployeeResponse().toString());
		return dto;
	}

//	public List<Long> retriveAllEmpWaitingForLeaveApproval()
//	{
//		
//	}
}
