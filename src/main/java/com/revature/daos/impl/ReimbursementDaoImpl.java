package com.revature.daos.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.utlities.HibernateUtil;

@Repository
public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getAllReims() {
		List<Reimbursement> reims = null;
		
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			
			cq.select(cq.from(Reimbursement.class));
			
			Query<Reimbursement> query = s.createQuery(cq);
			reims = query.list();
		}
		return reims;
	}

	@Override
	public Reimbursement getReimById(int reimId) {
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Reimbursement where reim_id = :id";
			Query<Reimbursement> q = s.createQuery(hql, Reimbursement.class);
			q.setParameter("id", reimId);
			Reimbursement r = q.getSingleResult();
			
			return r;
		}
	}

	@Override
	public List<Reimbursement> getReimsByEmpl(int emplId) {
		List<Reimbursement> reims = null;

		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Reimbursement where submit_by = :id";
			Query<Reimbursement> q = s.createQuery(hql, Reimbursement.class);
			q.setParameter("id", emplId);
			reims = q.list();
			
			return reims;
		}
	}

	@Override
	public int createReim(Reimbursement r) {
		int emplCreated = 0;
		
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			emplCreated = (int) s.save(r);
			tx.commit();
			return emplCreated;
		}
	}

	@Override
	public void updateReim(Reimbursement r) {
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.update(r);
			tx.commit();
		}
	}

	@Override
	public void deleteReim(int reimId) {
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(new Reimbursement(reimId));
			tx.commit();
		}
	}

	@Override
	public void deleteReimsByEmpl(int emplId) {
		List<Reimbursement> reims = this.getReimsByEmpl(emplId);
		
		for (Reimbursement r: reims) {
			this.deleteReim(r.getReimId());
		}
	}

}
