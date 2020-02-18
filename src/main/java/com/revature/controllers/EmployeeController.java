package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return es.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getOneEmployee(@PathVariable(value="id")int id) {
		return es.getEmployee(id);
	}
	
}
