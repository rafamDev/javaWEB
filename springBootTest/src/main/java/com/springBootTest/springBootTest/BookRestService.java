package com.springBootTest.springBootTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookRestService {

	 private BookRepository repository;
	 
	 //I get the 'dao' in a class service. 
	 @Autowired
	 public BookRestService(BookRepository repository) {
		this.repository = repository;
	 }
	 
	 @GetMapping("/")
	 public String getIndex(){
	   return "<h1>" + repository.getMSG() + "<h1>";
	 }
	 
	 
	 @GetMapping("/books")
	 public List<Book> findAll() {
	    return repository.findAll();
	    //This return only one repository with a list of books.
	 }
}
