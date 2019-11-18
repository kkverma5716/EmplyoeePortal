package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.example.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	List<Employee> list = new CopyOnWriteArrayList<>();

	@Override
	public List<Employee> getAllEmployee() {
		ArrayList<Employee> empList = new ArrayList<Employee>(list);
		empList.sort((emp1, emp2) -> emp1.getFirstName().compareTo(emp2.getFirstName()));
		return empList;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		list.add(emp);
		return emp;
	}

}
