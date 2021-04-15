package com.jhm.admdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhm.admdash.model.dto.CustomerDto;
import com.jhm.admdash.service.CustomerService;

@RestController
@RequestMapping(value="/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customers/{id}", method = RequestMethod.GET)
	public CustomerDto getCustomer(@PathVariable("id") String id){
		
		Long customerId = Long.parseLong(id);
		CustomerDto customer = customerService.getCustomer(customerId);
		return customer;
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.POST)
	public boolean addCustomer(@RequestBody CustomerDto customer){
		
		boolean saved = customerService.addCustomer(customer);
		return saved;
	}
	
	@RequestMapping(value="/customers/{id}", method = RequestMethod.PUT)
	public boolean updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDto customer){
		
		boolean saved = customerService.updateCustomer(customer);
		return saved;
	}
	
	@RequestMapping(value="/customers/{id}", method = RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable("id") String id){
		
		Long customerId = Long.parseLong(id);
		boolean saved = customerService.deleteCustomer(customerId);
		return saved;
	}
	
}
