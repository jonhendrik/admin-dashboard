package com.jhm.admdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhm.admdash.model.dto.InvoiceDto;
import com.jhm.admdash.service.InvoiceService;

@RestController
@RequestMapping(value="/api")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	@RequestMapping(value="/invoices/{id}", method = RequestMethod.GET)
	public InvoiceDto getCustomer(@PathVariable("id") String id){
		
		Long invoiceId = Long.parseLong(id);
		InvoiceDto invoice = invoiceService.getInvoice(invoiceId);
		return invoice;
	}
	
	@RequestMapping(value="/invoices", method = RequestMethod.POST)
	public boolean addCustomer(@RequestBody InvoiceDto invoice){
		
		boolean saved = invoiceService.addInvoice(invoice);
		return saved;
	}
	
	@RequestMapping(value="/invoices/{id}", method = RequestMethod.PUT)
	public boolean updateCustomer(@PathVariable("id") String id, @RequestBody InvoiceDto invoice){
		
		boolean saved = invoiceService.updateInvoice(invoice);
		return saved;
	}
	
	@RequestMapping(value="/invoices/{id}", method = RequestMethod.DELETE)
	public boolean deleteCustomer(@PathVariable("id") String id){
		
		Long invoiceId = Long.parseLong(id);
		boolean saved = invoiceService.deleteInvoice(invoiceId);
		return saved;
	}
	
}
