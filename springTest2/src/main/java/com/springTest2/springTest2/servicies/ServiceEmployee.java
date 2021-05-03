package com.springTest2.springTest2.servicies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.springTest2.springTest2.entities.Employee;

@Service
public class ServiceEmployee {

	private List<Employee> repository = new ArrayList<Employee>();
	
	public Employee addEmployee(Employee e){
		this.repository.add(e);
	  return e;	
	}

	public List<Employee> getRepository() {
		return this.repository;
	}	
	
	private List<Employee> getInitEmployees(){
		Employee e1 = new Employee(1,"Jack","jack@gmail.com","881345221");
		Employee e2 = new Employee(2,"Joe","Joe@gmail.com","881321377");
		Employee e3 = new Employee(3,"David","David@gmail.com","881321567");
		List<Employee> listEmployees = Arrays.asList(e1,e2,e3);
	  return listEmployees;	
	}
	
	@PostConstruct
	public void init() {
		this.repository.addAll(this.getInitEmployees());
	}
}
