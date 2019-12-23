package com.corlogy.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.corlogy.model.Employee;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
	@Autowired
    EntityManager entityManager;

	@Override
	public boolean updateEmployee(Long empId, String name, Date dob) {
		Employee e = entityManager.find(Employee.class, empId);
        if (e == null) {
            return false;
        }
        e.setName(name);
        e.setdOB(dob);
        entityManager.flush();
        return true;
	}

	@Override
	public Long getMaxEmpId() {
		try {
            String sql = "SELECT coalesce(max(e.employeeId), 0) FROM Employee e";
            Query query = entityManager.createQuery(sql);
            return (Long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0L;
        }
	}
}
