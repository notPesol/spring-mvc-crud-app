package com.pesol.webapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pesol.webapp.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("FROM Product", Product.class);
		return query.getResultList();
	}

	@Override
	public Product findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product.class, id);
	}

	@Override
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Product p WHERE p.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}

	@Override
	public List<Product> findAll(String sort) {
		Session session = sessionFactory.getCurrentSession();

		String hql = "FROM Product ORDER BY ";

		switch (sort.toLowerCase()) {
		case "quantity": {
			hql += sort;
			break;
		}
		default:
			hql += "name";
			break;
		}

		Query<Product> query = session.createQuery(hql, Product.class);

		return query.getResultList();
	}

	@Override
	public List<Product> findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("FROM Product p WHERE p.name LIKE :name ORDER BY p.name", 
				Product.class);
		query.setParameter("name", '%' + name + '%');
		return query.getResultList();
	}

}
