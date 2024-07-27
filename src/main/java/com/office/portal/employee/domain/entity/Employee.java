package com.office.portal.employee.domain.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long employeeId;
	
//	@NotNull
	String empRef;
	
	@NonNull
	String employeeName;
//	String employeeRef;
	String employeeAddress;
	
	@NonNull
//	@Pattern()
	Long contact;
	Long secContact;
	String bloodGroup;
	String passportNo;
	String panNo;
	String aadharNo;
	String supervisorName;
	Long supervisorEmpId;
	String supervisorEmail;
//	
//	@PrePersist
//	public void prePersist ()
//	{
//		if(employee_Id!=null && employee_Name!=null)
//		{
//			empRef=employee_Name.replace(" ", "-")+"_"+employee_Id;
//		}
//	}
	public String getEmpRef() {
		return empRef;
	}
	public void setEmpRef(String empRef) {
		this.empRef = empRef;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public Long getSecContact() {
		return secContact;
	}
	public void setSecContact(Long secContact) {
		this.secContact = secContact;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public Long getSupervisorEmpId() {
		return supervisorEmpId;
	}
	public void setSupervisorEmpId(Long supervisorEmpId) {
		this.supervisorEmpId = supervisorEmpId;
	}
	public String getSupervisorEmail() {
		return supervisorEmail;
	}
	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	
	
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeAddress=" + employeeAddress + ", contact="
				+ contact + ", secContact=" + secContact + ", bloodGroup=" + bloodGroup + ", passportNo=" + passportNo
				+ ", panNo=" + panNo + ", aadharNo=" + aadharNo + ", supervisorName=" + supervisorName
				+ ", supervisorEmpId=" + supervisorEmpId + ", supervisorEmail=" + supervisorEmail + "]";
	}


	
}
