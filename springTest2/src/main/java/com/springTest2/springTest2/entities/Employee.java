package com.springTest2.springTest2.entities;

public class Employee {

	private int id;
	
	private String name;
	
	private String email;
	
	private String phoneNumber;

	public Employee(int id, String name, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
}
