package com.jhm.admdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhm.admdash.model.Customer;
import com.jhm.admdash.service.CustomerService;

@RestController
@RequestMapping(value="/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public Customer getCustomer(@RequestParam String id){
		
		Long customerId = Long.parseLong(id);
		Customer customer = customerService.getCustomer(customerId);
		return customer;
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.POST)
	public boolean addCustomer(@RequestParam Customer customer){
		
		boolean saved = customerService.addCustomer(customer);
		return saved;
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.PUT)
	public boolean updateCustomer(@RequestParam Customer customer){
		
		boolean saved = customerService.updateCustomer(customer);
		return saved;
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.DELETE)
	public boolean deleteCustomer(@RequestParam String id){
		
		Long customerId = Long.parseLong(id);
		boolean saved = customerService.deleteCustomer(customerId);
		return saved;
	}
	
}
