package com.corlogy.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.corlogy.controller.EmployeeController;
import com.corlogy.model.Employee;
import com.corlogy.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value = { "/deleteEmpoyeeApi" }, method = RequestMethod.GET)
	public List<Employee> deleteEmpoyee(@RequestParam(value = "elpId", required = true) Long id) {
		try {
			employeeRepository.deleteById(id);
			List<Employee> employees = (List<Employee>) employeeRepository.findAll();
			return employees;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			LOGGER.error(e.getMessage());
			return new ArrayList<>();
		}
	}
	
	@RequestMapping(value = { "/ListAllEmpoyeeApi" }, method = RequestMethod.GET)
	public List<Employee> getListEmpoyee() {
		try {
			List<Employee> employees = (List<Employee>) employeeRepository.findAll();
			return employees;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			LOGGER.error(e.getMessage());
			return new ArrayList<>();
		}
	}
}
