package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String fullname;
	
	
	
	
	public Person() {
		super();
	}

	public Person(Long id, String name, String fullname) {
		super();
		this.id = id;
		this.name = name;
		this.fullname = fullname;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	

}
