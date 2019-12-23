package com.corlogy.repository;

import org.springframework.data.repository.CrudRepository;

import com.corlogy.model.UserSys;

public interface UserSysRepository extends CrudRepository<UserSys, Long>{
	public UserSys findByUserSysName(String usersysname);
}
