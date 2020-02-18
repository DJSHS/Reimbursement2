package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.impl.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

@Service
public class ReimbursementService {
	
	@Autowired
	private ReimbursementDaoImpl re;
	
	public List<Reimbursement> getAllReimbursements() {
		return re.getAllReims();
	}
	
	public Reimbursement getReimbursement(int reimId) {
		return re.getReimById(reimId);
	}
	
	public List<Reimbursement> getAllReimbursementsByEmpl(int emplId) {
		return re.getReimsByEmpl(emplId);
	}
	
	public int createReimbursement(Reimbursement r) {
		return re.createReim(r);
	}
	
	public void updateReimbursement(Reimbursement r) {
		re.updateReim(r);
	}
	
	public void deleteReimbursement(int reimId) {
		re.deleteReim(reimId);
	}
	
	public void deleteReimbursementByEmpl(int emplId) {
		re.deleteReimsByEmpl(emplId);
	}
}
