package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	public List<Reimbursement> getAllReims();
	public Reimbursement getReimById(int reimId);
	public List<Reimbursement> getReimsByEmpl(int emplId);
	public int createReim(Reimbursement r);
	public void updateReim(Reimbursement r);
	public void deleteReim(int reimId);
	public void deleteReimsByEmpl(int emplId);
	public List<Reimbursement> getPendingReims();
	public List<Reimbursement> getResolvedReims();
	public List<Reimbursement> getPendingReimByEmpl(int emplId);
	public List<Reimbursement> getResolvedReimByEmpl(int emplId);
}
