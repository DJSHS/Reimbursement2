package com.revature.daos.impl;

import java.util.List;

import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;
import com.revature.utlities.HibernateUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private ReimbursementDaoImpl re;
	
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
			Query<Employee> q = s.createQuery(hql, Employee.class);
			q.setParameter("id", emplId);
			Employee e = q.getSingleResult();
			
			return e;
		}
	}

	@Override
	public int createEmpl(Employee e) {
		int emplCreated = 0;
		
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			emplCreated = (int) s.save(e);
			tx.commit();
			return emplCreated;
		}
	}

	@Override
	public void updateEmpl(Employee e) {
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.update(e);
			tx.commit();
		}
	}

	@Override
	public void deleteEmpl(int emplId) {
		re.deleteReimsByEmpl(emplId);
		
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(new Employee(emplId));
			tx.commit();
		}
	}

	@Override
	public Employee login(String email, String password) {
		
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Employee where email = :email and pass = :pass";
			Query<Employee> q = s.createQuery(hql, Employee.class);
			q.setParameter("email", email);
			q.setParameter("pass", password);
			List<Employee> e = q.getResultList();
			
			return e.isEmpty() ? null : e.get(0);
		}
	}

	@Override
	public boolean checkEmail(String email) {		
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Employee where email = :email";
			Query<Employee> q = s.createQuery(hql, Employee.class);
			q.setParameter("email", email);
			List<Employee> e = q.getResultList();
			
			return e.isEmpty();
		}
	}

	@Override
	public boolean checkPhone(String phone) {
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Employee where phone = :phone";
			Query<Employee> q = s.createQuery(hql, Employee.class);
			q.setParameter("phone", phone);
			List<Employee> e = q.getResultList();
			
			return e.isEmpty();
		}
	}

}
