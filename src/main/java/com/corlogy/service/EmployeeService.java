package com.corlogy.service;

import java.util.List;

import com.corlogy.model.Employee;

public interface EmployeeService {
	public boolean addNewEmployee(Employee emlp);
	public boolean editEmployee(Employee emlp);
	public boolean deleteEmployeeById(long emlpId);
	public Employee findEmployeeById(long emlpId);
	public List<Employee> findAllEmployee();
	public long getMaxEmployeeId();
}
