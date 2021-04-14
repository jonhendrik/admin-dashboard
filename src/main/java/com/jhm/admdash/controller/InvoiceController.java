package com.jhm.admdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhm.admdash.model.Invoice;
import com.jhm.admdash.service.InvoiceService;

@Controller
@RequestMapping(value="/api")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	@RequestMapping(value="/invoices", method = RequestMethod.GET)
	public Invoice getCustomer(@RequestParam String id){
		
		Long invoiceId = Long.parseLong(id);
		Invoice invoice = invoiceService.getInvoice(invoiceId);
		return invoice;
	}
	
	@RequestMapping(value="/invoices", method = RequestMethod.POST)
	public boolean addCustomer(@RequestParam Invoice invoice){
		
		boolean saved = invoiceService.addInvoice(invoice);
		return saved;
	}
	
	@RequestMapping(value="/invoices", method = RequestMethod.PUT)
	public boolean updateCustomer(@RequestParam Invoice invoice){
		
		boolean saved = invoiceService.updateInvoice(invoice);
		return saved;
	}
	
	@RequestMapping(value="/invoices", method = RequestMethod.DELETE)
	public boolean deleteCustomer(@RequestParam String id){
		
		Long invoiceId = Long.parseLong(id);
		boolean saved = invoiceService.deleteInvoice(invoiceId);
		return saved;
	}
	
}
