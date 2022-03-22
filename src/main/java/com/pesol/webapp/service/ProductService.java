package com.pesol.webapp.service;

import java.util.List;

import com.pesol.webapp.entity.Product;

public interface ProductService {

	List<Product> getProducts();

	Product getProduct(int id);

	void update(Product product);

	void delete(int id);

	void save(Product product);

	List<Product> getProducts(String sort);

	List<Product> getProductsByName(String name);

	
}
