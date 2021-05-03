package com.springBootTest.springBootTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository{
	
	private Book theBest = new Book("1","java","Manuel");
	
	public List<Book> findAll() {
	    List<Book> list = new ArrayList<Book>();
	    list.add(this.theBest);
	    list.add(new Book ("2","python","Gema"));
	  return list;
    }
	
	public String getNameOfBestBook(){
		return this.theBest.getName().toString();
	}
	
	public Book getBestBook(){
		return this.theBest;
	}
}
