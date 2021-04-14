package com.jhm.admdash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.Customer;
import com.jhm.admdash.model.Invoice;
import com.jhm.admdash.repository.InvoiceRepository;
import com.jhm.admdash.service.InvoiceService;

@Repository
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice getInvoice(Long id) {
		Invoice invoice = invoiceRepository.findById(id).get();
		return invoice;
	}

	@Override
	public boolean addInvoice(Invoice invoice) {
		boolean saved = false;
		Invoice invoiceEntity = invoiceRepository.findById(invoice.getId()).orElse(null);
		if (invoiceEntity == null) {
			invoiceRepository.save(invoice);
			saved = true;
		}
		return saved;
	}

	@Override
	public boolean updateInvoice(Invoice invoice) {
		boolean updated = false;
		Invoice invoiceEntity = invoiceRepository.findById(invoice.getId()).orElse(null);
		if (invoiceEntity != null) {
			invoiceEntity.setCustomer(invoice.getCustomer());
			invoiceEntity.setDescription(invoice.getDescription());
			invoiceEntity.setPurchaseDate(invoice.getPurchaseDate());
			invoiceEntity.setPurchasePrice(invoice.getPurchasePrice());
			
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
