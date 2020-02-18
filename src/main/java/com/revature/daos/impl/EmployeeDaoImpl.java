package com.revature.daos.impl;

import java.util.List;

import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;
import com.revature.utlities.HibernateUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getAllEmpls() {
		List<Employee> empls = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			
			cq.select(cq.from(Employee.class));
			
			Query<Employee> query = s.createQuery(cq);
			empls = query.list();
		}
		return empls;
	}

}
