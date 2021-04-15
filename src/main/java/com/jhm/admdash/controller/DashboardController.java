package com.jhm.admdash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhm.admdash.model.Account;
import com.jhm.admdash.model.Customer;
import com.jhm.admdash.repository.AccountRepository;
import com.jhm.admdash.repository.CustomerRepository;

@Controller
public class DashboardController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String showDashboard(ModelMap model){
		return "dashboard";
	}
    
    @RequestMapping(value="/createCustomer", method = RequestMethod.POST)
	public String showCustomer(ModelMap model, @RequestParam String account){
    	List<Account> accountList = (List<Account>) accountRepository.findAll();
    	model.put("account", account);
    	model.put("accountList", accountList);
		return "customer";
	}
    
    @RequestMapping(value="/updateCustomer/{id}", method = RequestMethod.GET)
   	public String showUpdateCustomer(ModelMap model, @PathVariable("id") String id){
       	List<Account> accountList = (List<Account>) accountRepository.findAll();
       	Customer customer = customerRepository.findById(Long.parseLong(id)).orElse(new Customer());
       	model.put("account", customer.getAccount());
       	model.put("customer", customer);
       	model.put("invoiceList", customer.getInvoiceList());
       	model.put("accountList", accountList);
   		return "customer";
   	}
    
    @RequestMapping(value="/createInvoice", method = RequestMethod.POST)
	public String showInvoice(ModelMap model,@RequestParam String account){
    	List<Customer> customerList = (List<Customer>) customerRepository.findAll();
    	model.put("account", account);
    	model.put("customerList", customerList);
		return "invoice";
	}
   
}
