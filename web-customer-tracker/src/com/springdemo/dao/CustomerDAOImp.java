package com.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Component
@Repository
public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = session.createQuery("from Customer",Customer.class);
		List<Customer> cust = theQuery.getResultList();
		System.out.println(cust);
		
		
		
		return cust;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class,id);
		
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class,id);
		session.delete(theCustomer);
		
	}
	
}
