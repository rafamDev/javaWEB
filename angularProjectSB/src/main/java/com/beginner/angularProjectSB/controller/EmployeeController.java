package com.beginner.angularProjectSB.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.beginner.angularProjectSB.exception.ResourceNotFoundException;
import com.beginner.angularProjectSB.model.Employee;
import com.beginner.angularProjectSB.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
//ResponseBody + Controller
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	private static final String EMPLOYEE_NOT_FOUND = "Employee not found in database: "; 
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return this.employeeRepo.findAll();
	}
	
	/**
	 * This method creates an employee.
	 * @param employee
	 * @return
	 */
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody final Employee employee) {
		return this.employeeRepo.save(employee);
	}
	
	private Employee employeeFoundToResponse(final Long id){
		return this.employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE_NOT_FOUND + id));
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable final Long id) { 
		return ResponseEntity.ok(employeeFoundToResponse(id));
		//Return the object found by id from controller to client via url.
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable final Long id, @RequestBody Employee employeeBody) { 
		Employee employee = employeeFoundToResponse(id);
		employee.setFirstName(employeeBody.getFirstName());
		employee.setLastName(employeeBody.getLastName());
		employee.setEmailId(employeeBody.getEmailId());
	  return ResponseEntity.ok(this.employeeRepo.save(employee));	
	}
}
