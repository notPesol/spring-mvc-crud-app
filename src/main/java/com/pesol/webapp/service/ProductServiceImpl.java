package com.pesol.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pesol.webapp.dao.ProductDao;
import com.pesol.webapp.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDao.findAll();
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		return productDao.findById(id);
	}

	@Override
	@Transactional
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	@Transactional
	public void delete(int id) {
		productDao.delete(id);
		
	}

	@Override
	@Transactional
	public void save(Product product) {
		productDao.save(product);
	}

	@Override
	@Transactional
	public List<Product> getProducts(String sort) {
		if(sort != null) {
			return productDao.findAll(sort);
		}
		
		return productDao.findAll();
	}

	@Override
	@Transactional
	public List<Product> getProductsByName(String name) {
		return productDao.findByName(name);
	}

}
