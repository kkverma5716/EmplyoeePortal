package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.model.Employee;
import com.example.service.IEmployeeService;

@RestController
@RequestMapping("/api")
@EnableWebMvc
public class EmployeeController {
	@Autowired
	IEmployeeService service;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@PostMapping("/register")
	public Employee registerEmployee(@Valid @RequestBody Employee emp) {
		return service.addEmployee(emp);
	}

}
