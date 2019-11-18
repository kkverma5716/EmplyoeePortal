package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmployee();

	public Employee addEmployee(Employee emp);
}
