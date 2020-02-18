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
	
	public int updateEmployee(Employee e) {
		return em.updateEmpl(e);
	}
	
	public int deleteEmployee(int emplId) {
		return em.deleteEmpl(emplId);
	}
}
