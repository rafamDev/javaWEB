package com.springBootTest.springBootTest;

public class Book {
   
   private String id;
   private String name;
   private String author;

   public Book(String id, String name, String author) {
	super();
	this.id = id;
	this.name = name;
	this.author = author;
  }

  public String getId() {
	return id;
  }

  public String getName() {
	return name;
  }

  public String getAuthor() {
	return author;
  }

  @Override
  public String toString() {
	return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
  }
   
}
