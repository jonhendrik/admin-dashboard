package com.jhm.admdash.service;

import com.jhm.admdash.model.Invoice;

public interface InvoiceService {

	public Invoice getInvoice(Long id);
	public boolean addInvoice(Invoice invoice);
	public boolean updateInvoice(Invoice invoice);
	public boolean deleteInvoice(Long id);
	
}
