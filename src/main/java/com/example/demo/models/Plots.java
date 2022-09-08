package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plots {

	@Id
	@GeneratedValue
	private long id;
	
	private double area;
	
	public Plots() {
		super();
	}
	
	public Plots(long id, double area) {
		super();
		this.id = id;
		this.area = area;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
}
