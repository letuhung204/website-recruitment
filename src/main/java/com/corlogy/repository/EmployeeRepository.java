package com.corlogy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.corlogy.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	public Employee findByName(String name);
	public List<Employee> findByDOBGreaterThan(Date dOB);
	public List<Employee> findByDOBLessThan(Date dOB);
}
