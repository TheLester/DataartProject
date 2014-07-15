package com.dataart.project.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRepositoryHibernateImpl implements CustomerRepository {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		return currentSession().createQuery("FROM Customer a").list();
	}

	@Override
	public void createCustomer(Customer customer) {
		currentSession().save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		Customer customer = (Customer) sessionFactory
				.getCurrentSession().get(Customer.class, id);
		currentSession().delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		currentSession().update(customer);
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
