package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private EmployeeService es;
	
	@PostMapping
	public Employee login(@RequestParam("email")String email, @RequestParam("password")String password) {
		return es.login(email, password);
	}
}
