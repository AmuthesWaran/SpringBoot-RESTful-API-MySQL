package com.ammu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/")
	public String sayHello() {
		return "<h1>Hello, World!</h1>";
	}
	
}
