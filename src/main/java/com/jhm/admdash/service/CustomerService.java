package com.jhm.admdash.service;

import com.jhm.admdash.model.Customer;

public interface CustomerService {

	public Customer getCustomer(Long id);
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(Long id);
	
}
