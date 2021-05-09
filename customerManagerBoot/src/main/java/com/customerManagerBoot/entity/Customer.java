package com.customerManagerBoot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String lastName;
	
	@Column
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn
	private City city;

	public Customer(long id, String name, String lastName, String phoneNumber, City city) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public City getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", city=" + city + "]";
	}
	
	
}
