package com.jhm.admdash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.Customer;
import com.jhm.admdash.repository.CustomerRepository;
import com.jhm.admdash.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer getCustomer(Long id) {
		Customer customer = customerRepository.findById(id).get();
		return customer;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean saved = false;
		Customer customerEntity = customerRepository.findById(customer.getId()).orElse(null);
		if (customerEntity == null) {
			customerRepository.save(customer);
			saved = true;
		}
		return saved;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean updated = false;
		Customer customerEntity = customerRepository.findById(customer.getId()).orElse(null);
		if (customerEntity != null) {
			customerEntity.setAccount(customer.getAccount());
			customerEntity.setName(customer.getName());
			
			customerRepository.save(customerEntity);
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteCustomer(Long id) {
		boolean deleted = false;
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer != null) {
			customerRepository.delete(customer);
			deleted = true;
		}
		return deleted;
	}

}
