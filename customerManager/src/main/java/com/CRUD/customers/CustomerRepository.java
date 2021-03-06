package com.CRUD.customers;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//This it would be the "DAO" definition.
//Methods(list,delete...) are extended by the parent interface.
//This gives me the chance to have all methods needed to build a "DAO singleton object" based on the customer pojo.
//This interface has the information of table customer in database thanks to customer entity (hibernate).
public interface CustomerRepository extends CrudRepository<Customer,Long> {

	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.address LIKE '%' || :keyword || '%'")
    public List<Customer> search(@Param("keyword") String keyword);
	/*<form method="get" action="search">
    <input type="text" name="keyword"/> &nbsp;
    <input type="submit" value="Search"/>
    </form>*/
	//Annotation @Param is necessary in query. 
	
}
