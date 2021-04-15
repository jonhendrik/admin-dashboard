package com.jhm.admdash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {
	
    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String showDashboard(ModelMap model){
		return "dashboard";
	}
    
    @RequestMapping(value="/createCustomer", method = RequestMethod.POST)
	public String showCustomer(ModelMap model, @RequestParam String account){
    	
    	model.put("account", account);
		return "customer";
	}
    
    @RequestMapping(value="/createInvoice", method = RequestMethod.POST)
	public String showInvoice(ModelMap model,@RequestParam String account){
    	
    	model.put("account", account);
		return "invoice";
	}
   
}
