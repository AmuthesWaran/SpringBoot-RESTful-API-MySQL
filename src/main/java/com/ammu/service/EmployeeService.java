package com.ammu.service;

import java.util.List;


import com.ammu.model.Employee;

public interface EmployeeService {
	
	// POST
	public Employee addAnEmployee(Employee employee);
	
	// GET an Employee
	public Employee findEmployeeByID(Long employeeId);
	
	// GET all Employees
	public List<Employee> getAllEmployees();
	
	// PUT
	public Employee amendAnEmployee(Employee employee);
	
	// DELETE
	public Employee deleteAnEmployee(Long employeeId);
	

}
