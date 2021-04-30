package com.springBootTest.springBootTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 public String getMSG(){
	   return "<h1>" + repository.getMSG() + "<h1>";
	 }
	 
	 
	 @GetMapping("/books")
	 public List<Book> findAll() {
	    return repository.findAll();
	    //This return only one repository with a list of books.
	 }
	 
	 @GetMapping("/books/{nameBook}")
	 public String getBestBook(@PathVariable(value = "nameBook") String nameBook){
		return "<h1>Name of the best book is: " + repository.getBestBook() + "</h1>";
	 }
}
