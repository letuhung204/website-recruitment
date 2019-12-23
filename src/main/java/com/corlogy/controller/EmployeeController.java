package com.corlogy.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.corlogy.common.CommonCheck;
import com.corlogy.common.StringConstants;
import com.corlogy.model.Employee;
import com.corlogy.model.EmployeeError;
import com.corlogy.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private List<Employee> employees;
	private Employee employee;
	private Employee employeeEdit;
	private String successMsgTable;
	private String errorMsgTable;
	private EmployeeError employeeErr;
	private EmployeeError employeeErrEdit;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeServiceImpl employeeService;

	@PostConstruct
	public void init() {
		refreshMsg();
		clearData();
	}

	@RequestMapping(value = { "/listEmployee" }, method = RequestMethod.GET)
	public String getListAllEmployee(Model model, HttpSession session) {
		try {
			refreshMsg();
			clearData();
			employees = employeeService.findAllEmployee();
			setModelAttributes(model);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return "employee";
	}

	@RequestMapping(value = { "/addEmpoyee" }, method = RequestMethod.POST)
	public String addEmpoyee(@ModelAttribute("employee") Employee elp, Model model) {
		refreshMsg();
		employee = new Employee(elp);
		try {
			employee.setEmployeeId(employeeService.getMaxEmployeeId() + 1);

			if (isValidEmployee(employee) && employeeService.addNewEmployee(employee)) {
				successMsgTable = StringConstants.employee_success_add_msg;
			} else {
				errorMsgTable = StringConstants.employee_error_add_msg;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			employees = employeeService.findAllEmployee();
			setModelAttributes(model);
		}

		return "employee";
	}
	
	@RequestMapping(value = { "/preEditEmpoyee" }, method = RequestMethod.GET)
	public String preEditEmpoyee(@RequestParam(value = "elpId", required = true) Long id, Model model) {
		refreshMsg();
		try {
			employeeEdit = employeeService.findEmployeeById(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			setModelAttributes(model);
		}

		return "employee";
	}

	@RequestMapping(value = { "/editEmpoyee" }, method = RequestMethod.POST)
	public String editEmpoyee(@ModelAttribute("employeeEdit") Employee elp, Model model) {
		refreshMsg();
		employeeEdit = new Employee(elp);
		try {
			if (isValidEmployeeEdit(employeeEdit) && employeeService.editEmployee(employeeEdit)) {
				successMsgTable = StringConstants.employee_success_update_msg;
			} else {
				errorMsgTable = StringConstants.employee_error_update_msg;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			employees = employeeService.findAllEmployee();
			setModelAttributes(model);
		}

		return "employee";
	}

	@RequestMapping(value = { "/deleteEmpoyee" }, method = RequestMethod.POST)
	public String deleteEmpoyee(@RequestParam(value = "elpId", required = true) Long id, Model model) {
		refreshMsg();
		try {
			if (employeeService.deleteEmployeeById(id)) {
				successMsgTable = StringConstants.employee_success_delete_msg;
			} else {
				errorMsgTable = StringConstants.employee_error_delete_msg;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			employees = employeeService.findAllEmployee();
			setModelAttributes(model);
		}

		return "employee";
	}

	@RequestMapping(value = { "/refreshData" }, method = RequestMethod.GET)
	public String refreshData() {
		return "redirect:listEmployee";
	}

	public boolean isValidEmployee(Employee employee) {
		if (CommonCheck.isNullOrEmpty(employee.getName())) {
			employeeErr.setNameErr(StringConstants.employee_error_name);
			return false;
		}
		if (CommonCheck.isNullOrEmpty(employee.getAge())) {
			employeeErr.setAgeErr(StringConstants.employee_error_age);
			return false;
		}
		if (CommonCheck.isNullOrEmpty(employee.getAddress())) {
			employeeErr.setAddressErr(StringConstants.employee_error_address);
			return false;
		}
		if (CommonCheck.isNull(employee.getdOB())) {
			employeeErr.setDobErr(StringConstants.employee_error_dob);
			return false;
		}

		return true;
	}
	
	public boolean isValidEmployeeEdit(Employee employee) {
		if (CommonCheck.isNullOrEmpty(employee.getName())) {
			employeeErrEdit.setNameErr(StringConstants.employee_error_name);
			return false;
		}
		if (CommonCheck.isNullOrEmpty(employee.getAge())) {
			employeeErrEdit.setAgeErr(StringConstants.employee_error_age);
			return false;
		}
		if (CommonCheck.isNullOrEmpty(employee.getAddress())) {
			employeeErrEdit.setAddressErr(StringConstants.employee_error_address);
			return false;
		}
		if (CommonCheck.isNull(employee.getdOB())) {
			employeeErrEdit.setDobErr(StringConstants.employee_error_dob);
			return false;
		}

		return true;
	}
	
	public void setModelAttributes(Model model) {
		model.addAttribute("employees", employees);
		model.addAttribute("employee", employee);
		model.addAttribute("employeeEdit", employeeEdit);
		model.addAttribute("successMsgTable", successMsgTable);
		model.addAttribute("errorMsgTable", errorMsgTable);
		model.addAttribute("employeeErr", employeeErr);
		model.addAttribute("employeeErrEdit", employeeErrEdit);
	}

	public void refreshMsg() {
		successMsgTable = "";
		errorMsgTable = "";
		employeeErr = new EmployeeError();
		employeeErrEdit = new EmployeeError();
	}
	
	public void clearData() {
		employee = new Employee();
		employeeEdit = new Employee();
	}
}
