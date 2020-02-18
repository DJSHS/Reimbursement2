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
	
	@PostMapping
	public int createEmployee(@RequestBody Employee e) {
		return es.createEmployee(e);
	}
	
	@PutMapping("/{id}")
	public void updateEmployee(@RequestBody Employee e) {
		es.updateEmployee(e);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable(value="id")int id) {
		es.deleteEmployee(id);
	}
	
	@PostMapping("/email")
	public boolean checkUniqueEmail(@RequestParam("email")String email) {
		return es.checkUniqueEmail(email);
	}
	
	@PostMapping("/phone")
	public boolean checkUniquePhone(@RequestParam("phone")String phone) {
		return es.checkUniquePhone(phone);
	}
	
}
