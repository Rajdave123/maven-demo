package com.phoenix.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.phoenix.daos.ProductDao;
import com.phoenix.daos.ProductDaoImpl;
import com.phoenix.data.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.ServiceException;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;

	// DC
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	List<Product> products = new ArrayList<Product>();

	@Override
	public List<Product> findAll() throws ServiceException {
		products = productDao.getAll();
		return products;
	}

	@Override
	public Product findProductById(int id) throws ProductNotFoundException {
		Product product = productDao.getProductById(id);
		if (product != null)
			return product;
		else
			throw new ProductNotFoundException("Sorry! product is not found");

	}

	@Override
	public void add(Product product) throws ServiceException {
		productDao.insert(product);
	}

	@Override
	public void edit(Product product) throws ServiceException {
		productDao.update(product);
	}

	@Override
	public void remove(Product product) throws ServiceException {
		productDao.delete(product);
	}

	@Override
	public List<Product> findByName(String name) throws ServiceException {
		// TODO Auto-generated method stub
		products = productDao.getAll();
		return products.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());

	}

	@Override
	public List<Product> findByBrand(String brand) throws ServiceException {
		// TODO Auto-generated method stub
		products = productDao.getAll();
		return products.stream().filter(p -> p.getBrand().equals(brand)).collect(Collectors.toList());

	}

	@Override
	public List<Product> findByPrice(float price) throws ServiceException {
		// TODO Auto-generated method stub
		products = productDao.getAll();
		return products.stream().filter(p -> p.getPrice() == price).collect(Collectors.toList());

	}

	@Override
	public List<Product> findByPriceRange(float minPrice, float maxPrice) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameAndBrand(String name, String brand) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameAndPrice(String name, float price) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByBrandAndPrice(String brand, float price) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortByName() throws ServiceException {
		return productDao.getAll().stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
	}

	@Override
	public List<Product> sortByBrand() throws ServiceException {
		// TODO Auto-generated method stub
		return productDao.getAll().stream().sorted(Comparator.comparing(Product::getBrand)).collect(Collectors.toList());
	}

	@Override
	public List<Product> sortByPrice() throws ServiceException {
		// TODO Auto-generated method stub
		return productDao.getAll().stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
	}

	@Override
	public List<Product> sortByPriceDesc() throws ServiceException {
		// TODO Auto-generated method stub
		return productDao.getAll().stream().sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
	}

}
