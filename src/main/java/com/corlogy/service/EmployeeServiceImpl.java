package com.corlogy.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corlogy.model.Employee;
import com.corlogy.repository.EmployeeRepository;
import com.corlogy.repository.EmployeeRepositoryCustomImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeRepositoryCustomImpl employeeRepositoryCustom;

	@Override
	public boolean addNewEmployee(Employee emlp) {
		try {
			employeeRepository.save(emlp);
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean editEmployee(Employee emlp) {
		try {
			employeeRepository.save(emlp);
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeById(long emlpId) {
		try {
			employeeRepository.deleteById(emlpId);
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public Employee findEmployeeById(long emlpId) {
		Optional<Employee> optionElp = employeeRepository.findById(emlpId);
		return optionElp.get();
	}

	@Override
	public long getMaxEmployeeId() {
		return employeeRepositoryCustom.getMaxEmpId();
	}

	@Override
	public List<Employee> findAllEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}
	
}
