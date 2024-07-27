package com.office.portal.employee.infra.request;

public class CreateEmployeeRequest {
	String employee_Name;
	String employee_Address;
	Long contact;
	Long sec_Contact;
	String blood_Group;
	String passport_No;
	String pan_No;
	String aadhar_No;
	String supervisor_Name;
	String supervisor_EmpId;
	String supervisor_Email;
	public String getEmployee_Name() {
		return employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}
	public String getEmployee_Address() {
		return employee_Address;
	}
	public void setEmployee_Address(String employee_Address) {
		this.employee_Address = employee_Address;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public Long getSec_Contact() {
		return sec_Contact;
	}
	public void setSec_Contact(Long sec_Contact) {
		this.sec_Contact = sec_Contact;
	}
	public String getBlood_Group() {
		return blood_Group;
	}
	public void setBlood_Group(String blood_Group) {
		this.blood_Group = blood_Group;
	}
	public String getPassport_No() {
		return passport_No;
	}
	public void setPassport_No(String passport_No) {
		this.passport_No = passport_No;
	}
	public String getPan_No() {
		return pan_No;
	}
	public void setPan_No(String pan_No) {
		this.pan_No = pan_No;
	}
	public String getAadhar_No() {
		return aadhar_No;
	}
	public void setAadhar_No(String aadhar_No) {
		this.aadhar_No = aadhar_No;
	}
	public String getSupervisor_Name() {
		return supervisor_Name;
	}
	public void setSupervisor_Name(String supervisor_Name) {
		this.supervisor_Name = supervisor_Name;
	}
	public String getSupervisor_EmpId() {
		return supervisor_EmpId;
	}
	public void setSupervisor_EmpId(String supervisor_EmpId) {
		this.supervisor_EmpId = supervisor_EmpId;
	}
	public String getSupervisor_Email() {
		return supervisor_Email;
	}
	public void setSupervisor_Email(String supervisor_Email) {
		this.supervisor_Email = supervisor_Email;
	}
	
	
	
	
}
