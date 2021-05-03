package com.springBootTest.springBootTest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody + @Controller
//Methods will return the body response.
//Controller + service.
@RestController
public class BookRestService {
      
	 private BookRepository repository;
	 
	 //It is now more common to define the dependency injection in constructors.
	 @Autowired
	 public BookRestService(BookRepository repository) {
		this.repository = repository;
	 }
	 
	 @GetMapping("/")
	 public String index(){
	   return "<h1> WELCOME TO JAVA BOOKSHOP<h1>";
	   //This returns a view in browser as a body response.
	 }
	 
	 @GetMapping("/{nameBook}")
	 public String getNameOfBestBook(@PathVariable(value = "nameBook") String nameBook){
	   return "<h1>" + repository.getNameOfBestBook() + "<h1>";
	   //This returns a view in the browser as a body response.
	 }
	 
	 @GetMapping("/books")
	 public List<Book> findAll() {
	    return repository.findAll();
	    //This returns a json file (thanks to jackson library) which should be handled.
	 }
	 
	 @GetMapping("/books/bestbook")
	 public Book getBestBook(String nameBook){
		return repository.getBestBook();
		//This returns a json file (thanks to jackson library) which should be handled.
	 }
}
