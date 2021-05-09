package com.customerManagerBoot.service;

import java.util.List;

import com.customerManagerBoot.entity.Customer;

public interface ICustomerService {

	public List<Customer> listAll();
	
	public Customer findById(Long id);
	
	public void save(Customer customer);
	
    public void delete(Customer customer);
    
    //In this project i won´t use update.
	
}
