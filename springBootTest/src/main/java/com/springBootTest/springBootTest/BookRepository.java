package com.springBootTest.springBootTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

//There will be just one object of this class.
@Repository
public class BookRepository {
	
	public List<Book> findAll() {
	    List<Book> list = new ArrayList<Book>();
	    list.add(new Book ("1","java","Manuel"));
	    list.add(new Book ("2","python","Gema"));
	  return list;
    }
}
