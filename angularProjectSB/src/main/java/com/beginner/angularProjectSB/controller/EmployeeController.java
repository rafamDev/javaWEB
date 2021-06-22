package com.beginner.angularProjectSB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beginner.angularProjectSB.model.Employee;
import com.beginner.angularProjectSB.repository.EmployeeRepository;

//ResponseBody + Controller
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return this.employeeRepo.findAll();
	}
	
	
}
