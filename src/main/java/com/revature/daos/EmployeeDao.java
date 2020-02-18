package com.revature.daos;

import com.revature.models.Employee;

import java.util.List;

public interface EmployeeDao {
	public List<Employee> getAllEmpls();
	public Employee getEmplById(int emplId);
	public int createEmpl(Employee e);
	public void updateEmpl(Employee e);
	public void deleteEmpl(int emplId);
	public Employee login(String email, String password);
	public boolean checkEmail(String email);
	public boolean checkPhone(String phone);
}
