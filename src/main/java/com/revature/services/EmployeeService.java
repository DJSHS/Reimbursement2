package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.impl.EmployeeDaoImpl;
import com.revature.models.Employee;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDaoImpl em;
	
	public List<Employee> getAllEmployees() {
		return em.getAllEmpls();
	}
	
	public Employee getEmployee(int emplId) {
		return em.getEmplById(emplId);
	}
	
	public int createEmployee(Employee e) {
		return em.createEmpl(e);
	}
	
	public void updateEmployee(Employee e) {
		em.updateEmpl(e);
	}
	
	public void deleteEmployee(int emplId) {
		em.deleteEmpl(emplId);
	}
	
	public Employee login(String email, String password) {
		return em.login(email, password);
	}
	
	public boolean checkUniqueEmail(String email) {
		return em.checkEmail(email);
	}
	
	public boolean checkUniquePhone(String phone) {
		return em.checkPhone(phone);
	}
}
