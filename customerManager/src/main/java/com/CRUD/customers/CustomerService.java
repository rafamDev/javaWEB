package com.CRUD.customers;

import java.util.List;
import java.util.Optional;

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
	
	public void save(Customer customer) {
		this.repo.save(customer);
	}
	
	public Customer getById(long id) {
		Optional<Customer> result = this.repo.findById(id);
		return result.get();
	}

	public void delete(long id) {
	   this.repo.deleteById(id);
	}
	
	public List<Customer> search(String keyword) {
	    return repo.search(keyword);
	}
}
