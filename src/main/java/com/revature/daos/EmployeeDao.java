package com.revature.daos;

import com.revature.models.Employee;

import java.util.List;

public interface EmployeeDao {
	public List<Employee> getAllEmpls();
	public Employee getEmplById(int emplId);
	public int createEmpl(Employee e);
	public int updateEmpl(Employee e);
	public int deleteEmpl(int emplId);
}
