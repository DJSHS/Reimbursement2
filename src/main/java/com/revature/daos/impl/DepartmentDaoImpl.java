package com.revature.daos.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.daos.DepartmentDao;
import com.revature.models.Department;
import com.revature.utlities.HibernateUtil;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> getAllDepts() {
		List<Department> depts = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Department> cq = cb.createQuery(Department.class);
			
			cq.select(cq.from(Department.class));
			
			Query<Department> query = s.createQuery(cq);
			depts = query.list();
		}
		return depts;
	}
	
}
