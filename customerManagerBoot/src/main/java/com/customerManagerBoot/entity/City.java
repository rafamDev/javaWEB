package com.customerManagerBoot.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	
	@Column
	private String city;

	public City(long id, String city) {
		super();
		this.id = id;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + "]";
	}
 
}
