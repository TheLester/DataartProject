package com.dataart.project.repositories;

import java.util.List;

public interface CustomerRepository {
	public List<Customer> getCustomers();

	public void createCustomer(Customer customer);

	public void deleteCustomer(int id);

	public void updateCustomer(Customer customer);
}
