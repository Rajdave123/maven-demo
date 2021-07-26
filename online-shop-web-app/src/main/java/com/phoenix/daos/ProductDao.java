package com.phoenix.daos;

import java.util.List;

import com.phoenix.data.Product;
/*
 * @author: raj.dave@stltech.in
  * version: 2.0
 * */
public interface ProductDao {

	List<Product> getAll();

	Product getProductById(int id);

	void insert(Product user);

	void update(Product uesr);

	void delete(Product user);
}
