package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Department;
import com.revature.services.DepartmentService;

@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentController {
	
	@Autowired
	private DepartmentService ds;
	
	@GetMapping
	public List<Department> getAllDepartments() {
		return ds.getAllDepartments();
	}
}
