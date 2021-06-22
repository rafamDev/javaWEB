package com.beginner.angularProjectSB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beginner.angularProjectSB.model.Employee;

/* JpaRepository extends of PagingAndSortingRepository 
   and it also extends of CrudRepository so if we need 
   more tools than crud we should use jpaRepository.
*/ 

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
