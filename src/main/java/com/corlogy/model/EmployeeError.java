package com.corlogy.model;

public class EmployeeError {
	private String nameErr;
	private String ageErr;
	private String addressErr;
	private String dobErr;
	
	public EmployeeError() {
		super();
		nameErr = "";
		ageErr = "";
		addressErr = "";
		dobErr = "";
	}

	public EmployeeError(String nameErr, String ageErr, String addressErr, String dobErr) {
		super();
		this.nameErr = nameErr;
		this.ageErr = ageErr;
		this.addressErr = addressErr;
		this.dobErr = dobErr;
	}
	
	public String getNameErr() {
		return nameErr;
	}
	
	public void setNameErr(String nameErr) {
		this.nameErr = nameErr;
	}
	
	public String getAgeErr() {
		return ageErr;
	}
	
	public void setAgeErr(String ageErr) {
		this.ageErr = ageErr;
	}
	
	public String getAddressErr() {
		return addressErr;
	}
	
	public void setAddressErr(String addressErr) {
		this.addressErr = addressErr;
	}
	
	public String getDobErr() {
		return dobErr;
	}
	
	public void setDobErr(String dobErr) {
		this.dobErr = dobErr;
	}
}
