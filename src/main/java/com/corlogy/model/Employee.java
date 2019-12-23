package com.corlogy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	private long employeeId;
	
	@Column(name = "name", length = 50, nullable = false, columnDefinition="nvarchar(50)")
	private String name;
	
	@Column(name = "age", length = 2, nullable = false)
	private String age;
	
	@Column(name = "address", length = 200, nullable = false, columnDefinition="nvarchar(200)")
	private String address;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dOB;
	
	public Employee() {
		super();
	}
	
	public Employee(Employee employee) {
		employeeId = employee.getEmployeeId();
		name = employee.getName();
		age = employee.getAge();
		address = employee.getAddress();
		dOB = employee.getdOB();
	}

	public Employee(String name, String age, String address, Date dOB) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.dOB = dOB;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getdOB() {
		return dOB;
	}
	
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", dOB=" + dOB + "]";
	}
}
