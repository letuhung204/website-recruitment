package com.corlogy.repository;

import java.util.Date;

public interface EmployeeRepositoryCustom {
	public Long getMaxEmpId();
	public boolean updateEmployee(Long empId, String name, Date dob);
}
