package com.corlogy.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserSysRepositoryCustomImpl implements UserSysRepositoryCustom {
	@Autowired
    EntityManager entityManager;

	@Override
	public Long getMaxUserSysId() {
		try {
            String sql = "SELECT coalesce(max(u.userSysId), 0) FROM user_sys u";
            Query query = entityManager.createQuery(sql);
            return (Long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0L;
        }
	}
}
