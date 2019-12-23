package com.corlogy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersys")
public class UserSys {
	@Id
	private long userSysId;
	
	@Column(name = "user_Sys_Name", length = 50, nullable = false, columnDefinition="varchar(50)")
	private String userSysName;
	
	@Column(name = "password", length = 50, nullable = false, columnDefinition="varchar(100)")
	private String password;
	
	@Column(name = "status", length = 10, nullable = false, columnDefinition="varchar(10)")
	private String status;
	
	public UserSys() {
		super();
	}
	
	public UserSys(long userSysId, String userSysName, String password, String status) {
		super();
		this.userSysId = userSysId;
		this.userSysName = userSysName;
		this.password = password;
		this.status = status;
	}
	
	public long getUserSysId() {
		return userSysId;
	}
	
	public void setUserSysId(long userSysId) {
		this.userSysId = userSysId;
	}
	
	public String getUserSysName() {
		return userSysName;
	}
	
	public void setUserSysName(String userSysName) {
		this.userSysName = userSysName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserSys [userSysId=" + userSysId + ", userSysName=" + userSysName + ", password=" + password
				+ ", status=" + status + "]";
	}
}
