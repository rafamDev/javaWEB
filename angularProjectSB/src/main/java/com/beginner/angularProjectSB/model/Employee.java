package com.beginner.angularProjectSB.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
  
  private static final long serialVersionUID = -7557609695660958507L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column(name="first_name")
  private String firstName;
 
  @Column(name="last_name")
  private String lastName;
  
  @Column(name="emailId")
  private String emailId;

  public Employee(long id, String name, String lastName, String emailId) {
	super();
	this.id = id;
	this.firstName = name;
	this.lastName = lastName;
	this.emailId = emailId;
  }
  
  public Employee() {
	  super();
  }

  public long getId() {
	 return id;
  }

  public void setId(long id) {
	this.id = id;
  }

  public String getFirstName() {
	return firstName;
  }

  public void setFirstName(String firstName) {
 	this.firstName = firstName;
  }

  public String getLastName() {
	return lastName;
  }

  public void setLastName(String lastName) {
	this.lastName = lastName;
  }

  public String getEmailId() {
	return emailId;
  }

  public void setEmailId(String emailId) {
	this.emailId = emailId;
  }

  
  
	
}
