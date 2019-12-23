package com.corlogy.model;

public class UserSysError {
	private String userSysNameErr;
	private String passwordErr;
	private String statusErr;
	
	public UserSysError() {
		super();
	}

	public UserSysError(String userSysNameErr, String passwordErr, String statusErr) {
		super();
		this.userSysNameErr = userSysNameErr;
		this.passwordErr = passwordErr;
		this.statusErr = statusErr;
	}

	public String getUserSysNameErr() {
		return userSysNameErr;
	}

	public void setUserSysNameErr(String userSysNameErr) {
		this.userSysNameErr = userSysNameErr;
	}

	public String getPasswordErr() {
		return passwordErr;
	}

	public void setPasswordErr(String passwordErr) {
		this.passwordErr = passwordErr;
	}

	public String getStatusErr() {
		return statusErr;
	}

	public void setStatusErr(String statusErr) {
		this.statusErr = statusErr;
	}
}
