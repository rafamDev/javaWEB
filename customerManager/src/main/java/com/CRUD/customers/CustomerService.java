package com.CRUD.customers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This service sets a kind of DAO singleton object provided by a java bean based on customer pojo.  
@Service
public class CustomerService {

	//Set the java bean object which has all information of the table customer. 
	@Autowired
	public CustomerRepository repo;
	
	//This would be the "DAO getLit()".
	public List<Customer> listAll(){
		return (List<Customer>) this.repo.findAll();
	}
}
