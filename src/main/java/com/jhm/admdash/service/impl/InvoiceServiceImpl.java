package com.jhm.admdash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.Customer;
import com.jhm.admdash.model.Invoice;
import com.jhm.admdash.model.dto.InvoiceDto;
import com.jhm.admdash.repository.CustomerRepository;
import com.jhm.admdash.repository.InvoiceRepository;
import com.jhm.admdash.service.InvoiceService;

@Repository
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public InvoiceDto getInvoice(Long id) {
		Invoice invoice = invoiceRepository.findById(id).orElse(null);
		InvoiceDto dto = new InvoiceDto();
		if (invoice != null) {
			dto.setId(invoice.getId());
			dto.setDescription(invoice.getDescription());
			dto.setPurchaseDate(invoice.getPurchaseDate());
			dto.setPurchasePrice(invoice.getPurchasePrice());
			dto.setCustomerId(invoice.getCustomer().getId());
		}
		
		return dto;
	}

	@Override
	public boolean addInvoice(InvoiceDto dto) {
		Invoice invoice = new Invoice();
		invoice.setDescription(dto.getDescription());
		invoice.setPurchaseDate(dto.getPurchaseDate());
		invoice.setPurchasePrice(dto.getPurchasePrice());
		
		Customer customer = customerRepository.findById(dto.getCustomerId()).orElse(null);
		invoice.setCustomer(customer);
		
		invoiceRepository.save(invoice);
		return true;
	}

	@Override
	public boolean updateInvoice(InvoiceDto dto) {
		boolean updated = false;
		Invoice invoiceEntity = invoiceRepository.findById(dto.getId()).orElse(null);
		if (invoiceEntity != null) {
			invoiceEntity.setCustomer(customerRepository.findById(dto.getCustomerId()).orElse(null));
			invoiceEntity.setDescription(dto.getDescription());
			invoiceEntity.setPurchaseDate(dto.getPurchaseDate());
			invoiceEntity.setPurchasePrice(dto.getPurchasePrice());
			
			invoiceRepository.save(invoiceEntity);
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteInvoice(Long id) {
		boolean deleted = false;
		Invoice invoice = invoiceRepository.findById(id).orElse(null);
		if (invoice != null) {
			invoiceRepository.delete(invoice);
			deleted = true;
		}
		return deleted;
	}


}
