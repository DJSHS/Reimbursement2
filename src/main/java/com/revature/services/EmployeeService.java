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
		List<Employee> empls = em.getAllEmpls();
		System.out.println(empls);
		return empls;
	}
	
}
