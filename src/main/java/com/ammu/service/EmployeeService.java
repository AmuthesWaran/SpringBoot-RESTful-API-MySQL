package com.ammu.service;

import java.util.List;

import com.ammu.model.Employee;

public interface EmployeeService {
	
	// Post
	public Employee addAnEmployee(Employee employee);
	
	// Get an Employee
	public Employee findEmployeeByID(Long employeeId);
	
	// Get all Employees
	public List<Employee> getAllEmployees();
	
	// PUT
	public Employee amendAnEmployee(Employee employee);
	
	// DELETE
	public Employee deleteAnEmployee(Long employeeId);
	

}
