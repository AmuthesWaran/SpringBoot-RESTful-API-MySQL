package com.ammu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ammu.model.Employee;
import com.ammu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public Employee addAnEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee findEmployeeByID(Long employeeId) {
		return empRepo.findById(employeeId).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee amendAnEmployee(Employee employee) {
		Employee updatedEmployee = empRepo.findById(employee.getEmpId()).get();
		updatedEmployee.setEmail(employee.getEmail());
		updatedEmployee.setFName(employee.getFName());
		updatedEmployee.setLName(employee.getLName());
		updatedEmployee.setHireDate(employee.getHireDate());
		updatedEmployee.setPhoneNo(employee.getPhoneNo());
		updatedEmployee.setSalary(employee.getSalary());
		
		return empRepo.save(updatedEmployee);
		
		
	}

	@Override
	public Employee deleteAnEmployee(Long employeeId) {
		Employee deletedEmployee = empRepo.findById(employeeId).get();
		empRepo.deleteById(employeeId);
		return deletedEmployee;
	}

}
