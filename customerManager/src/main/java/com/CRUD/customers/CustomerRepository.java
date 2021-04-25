package com.CRUD.customers;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
//This gives me the chance to have all methods needed to build a "DAO singleton object" based on a customer pojo.
//This interface has the information of table customer in database thanks to hibernate.

	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.address LIKE '%' || :keyword || '%'")
    public List<Customer> search(@Param("keyword") String keyword);

}
