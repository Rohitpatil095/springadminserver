package com.office.portal.employee.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.office.portal.employee.domain.entity.Employee;
import com.office.portal.employee.infra.response.CreateApplyLeaveEmployeeResponse;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	@Query(nativeQuery = true,
//			value = "select emp_id,leave_id from employee_leave where status='pending'")
//	public List<int[]> getEmpListPendingForLeaveApproval();
	
//	CHECK FOR ERROR ??
	@Query("SELECT new com.office.portal.employee.infra.response.CreateApplyLeaveEmployeeResponse(e.employeeId, e.employeeName, e.contact, e.secContact) "
		       + "FROM Employee e WHERE e.empRef = :empRef")
	public CreateApplyLeaveEmployeeResponse getEmpUsingEmpRef(@Param("empRef") String empRef);
	

//	@Query(nativeQuery = true,
//			value="SELECT e.employee_id,e.employee_name,e.contact,e.sec_contact"
//					+ " FROM employee e WHERE e.emp_ref = :empRef" )
//	public CreateApplyLeaveEmployeeResponse getEmpUsingEmpRef(@Param("empRef") String empRef);
}
