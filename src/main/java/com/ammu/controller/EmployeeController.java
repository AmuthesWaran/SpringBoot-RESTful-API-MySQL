package com.ammu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ammu.model.Employee;
import com.ammu.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empServ;
	
	@GetMapping("/")
	public String sayHello() {
		return "<h1>Hello, There</h1>";
	}
		
	@PostMapping("/employee")
	public ResponseEntity<Employee> addAnEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empServ.addAnEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<List<Employee>>(empServ.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> getAEmployee(@PathVariable Long empId){
		return new ResponseEntity<Employee>(empServ.findEmployeeByID(empId), HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<Employee> deleteAEmployee(@PathVariable Long empId){
		return new ResponseEntity<Employee>(empServ.deleteAnEmployee(empId), HttpStatus.OK);
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateAnEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empServ.amendAnEmployee(employee), HttpStatus.ACCEPTED);
	}

}
