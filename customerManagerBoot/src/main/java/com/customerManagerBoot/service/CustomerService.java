package com.customerManagerBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerManagerBoot.entity.City;
import com.customerManagerBoot.entity.Customer;
import com.customerManagerBoot.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerRepository repo;
	
	
	@Override
	public List<Customer> listAll() {
		List<Customer> lista = new ArrayList<Customer>();
		lista.add(new Customer(1,"Rafa","Mayo","123456789",new City(1,"Sada")));
		return lista;
		//return (List<Customer>) this.repo.findAll();
	}

	@Override
	public Customer findById(Long id) {
		//If there are not objects this returns null.
		return this.repo.findById(id).orElse(null);
	}

	@Override
	public void save(Customer customer) {
		this.repo.save(customer);
	}


	@Override
	public void delete(Customer customer) {
		this.repo.delete(customer);
	}

}
