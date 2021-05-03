package com.CRUD.customers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This it would be the "DAO".
//This service sets a kind of DAO singleton object based on the customer pojo.  
@Service
public class CustomerService {

	//"Dao singleton repository" (java bean object).
	//Dependency injection.
	@Autowired
	public CustomerRepository repo;
	
	
	public List<Customer> listAll(){
		return (List<Customer>) this.repo.findAll();
	}
	
	
	public void save(Customer customer) {
		this.repo.save(customer);
	}
	
    public Customer getById(long id) {
    	//I save the customer in a Optional (container object) and return the selected.
    	Optional<Customer> result = this.repo.findById(id);
		return result.get();
	}

	public void delete(long id,String name) {
	   this.repo.deleteById(id);
	   System.out.println("---------- User: " + name + " has been removed. ----------");
	}
	
	public List<Customer> search(String keyword) {
	    return repo.search(keyword);
	}
}
