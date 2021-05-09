package com.customerManagerBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customerManagerBoot.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
