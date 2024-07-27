package com.office.portal.employee.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.office.portal.employee.domain.entity.EmployeeLeave;

import jakarta.transaction.Transactional;

public interface EmployeeApplyLeaveRepository extends JpaRepository<EmployeeLeave, Long>{

//	@Transactional
	@Query(nativeQuery = true,
		value = "select emp_id,leave_id where status = \"pending\""
	)
	public List<String[]> getAllEmployeeIdsWithLeaveStatusAsPending();
}
