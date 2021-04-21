package com.springBootTest.springBootTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestService {

	 //I get the 'dao' in a class service. 
	 @Autowired
	 private BookRepository repository;
	  
	 @RequestMapping("/books")
	 public List<Book> findAll() {
	    return repository.findAll();
	 }
}
