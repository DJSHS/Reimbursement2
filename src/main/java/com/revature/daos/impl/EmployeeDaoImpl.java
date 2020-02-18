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

	@Override
	public Employee getEmplById(int emplId) {
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Employee where empl_id = :id";
			Query<Employee> p = s.createQuery(hql, Employee.class);
			p.setParameter("id", emplId);
			Employee e = p.getSingleResult();
			
			return e;
		}
	}

	@Override
	public int createEmpl(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmpl(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmpl(int emplId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
