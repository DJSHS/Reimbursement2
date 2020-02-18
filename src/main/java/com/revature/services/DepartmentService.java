package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.impl.DepartmentDaoImpl;
import com.revature.models.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDaoImpl d;
	
	public List<Department> getAllDepartments() {
		return d.getAllDepts();
	}
}
