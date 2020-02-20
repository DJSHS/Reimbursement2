package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

@RestController
@RequestMapping("/reimbursements")
@CrossOrigin
public class ReimbursementController {
	
	@Autowired
	private ReimbursementService rs;
	
	@GetMapping
	public List<Reimbursement> getAllReimbursements() {
		return rs.getAllReimbursements();
	}
	
	@GetMapping("/employees/{id}")
	public List<Reimbursement> getAllReimbursementsByEmpl(@PathVariable(value="id")int emplId) {
		return rs.getAllReimbursementsByEmpl(emplId);
	}
	
	@GetMapping("/{id}")
	public Reimbursement getOneReimbursement(@PathVariable(value="id")int id) {
		return rs.getReimbursement(id);
	}
	
	@PostMapping
	public int createReimbursement(@RequestBody Reimbursement r) {
		return rs.createReimbursement(r);
	}
	
	@PutMapping("/{id}")
	public void updateReimbursement(@RequestBody Reimbursement r) {
		rs.updateReimbursement(r);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReimbursement(@PathVariable(value="id")int id) {
		rs.deleteReimbursement(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteReimbursementByEmpl(@PathVariable(value="id")int id) {
		rs.deleteReimbursementByEmpl(id);
	}
	
	@GetMapping("/pending")
	public List<Reimbursement> getPendingReimbursements() {
		return rs.getPendingReimbursements();
	}
	
	@GetMapping("/resolved")
	public List<Reimbursement> getResolvedReimbursements() {
		return rs.getResolvedReimbursements();
	}
	
	@GetMapping("/employees/{id}/pending")
	public List<Reimbursement> getPendingReimbursementsByEmpl(@PathVariable(value="id")int emplId) {
		return rs.getPendingReimbursementsByEmpl(emplId);
	}
	
	@GetMapping("/employees/{id}/resolved")
	public List<Reimbursement> getResolvedReimbursementsByEmpl(@PathVariable(value="id")int emplId) {
		return rs.getResolvedReimbursementsByEmpl(emplId);
	}
}
