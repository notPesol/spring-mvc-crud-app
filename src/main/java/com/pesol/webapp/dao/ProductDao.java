package com.pesol.webapp.dao;

import java.util.List;

import com.pesol.webapp.entity.Product;

public interface ProductDao {

	List<Product> findAll();

	Product findById(int id);

	void update(Product product);

	void delete(int id);

	void save(Product product);

	List<Product> findAll(String sort);

	List<Product> findByName(String name);

}
