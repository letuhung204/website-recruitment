package com.corlogy.service;

import java.util.List;

import com.corlogy.model.UserSys;

public interface UserSysService {
	public UserSys findUserSysByUserSysName(String userSysName);
	public List<UserSys> findAllUserSys();
	public long getMaxUserSysId();
	public boolean addNewUserSys(UserSys userSys);
}
