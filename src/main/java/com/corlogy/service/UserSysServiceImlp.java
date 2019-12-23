package com.corlogy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corlogy.model.UserSys;
import com.corlogy.repository.UserSysRepository;
import com.corlogy.repository.UserSysRepositoryCustomImpl;

@Service
public class UserSysServiceImlp implements UserSysService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSysServiceImlp.class);
	
	@Autowired
	private UserSysRepository userSysRepository;

	@Autowired
	private UserSysRepositoryCustomImpl userSysRepositoryCustom;

	@Override
	public UserSys findUserSysByUserSysName(String userSysName) {
		return userSysRepository.findByUserSysName(userSysName);
	}

	@Override
	public List<UserSys> findAllUserSys() {
		return (List<UserSys>) userSysRepository.findAll();
	}

	@Override
	public long getMaxUserSysId() {
		return userSysRepositoryCustom.getMaxUserSysId();
	}

	@Override
	public boolean addNewUserSys(UserSys userSys) {
		try {
			userSysRepository.save(userSys);
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

}
