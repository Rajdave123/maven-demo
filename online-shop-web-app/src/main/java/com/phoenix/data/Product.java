package com.phoenix.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*author:  raj.dave@stltech.in
 * CreationDate:09-07-21
 * description:
 * version: 2.0
 * */

//Value Object class- java bean - pojo or Persistence class
@Entity
@Table(name = "product")
public class Product {

	// PDM
	@Id
	private int id;
	private String name;
	private String brand;
	private float price;

	// GETTERS & SETTERS METHODS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	// DC
	public Product() {
		super();
	}

	// PC
	public Product(int id, String name, String brand, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

}
