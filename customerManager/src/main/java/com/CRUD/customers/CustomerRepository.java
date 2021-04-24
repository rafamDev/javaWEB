package com.CRUD.customers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
//This gives me the chance to have all methods needed to build a "DAO singleton object" based on a customer pojo.
//This object has the information of table customer in database thanks to hibernate.
}
