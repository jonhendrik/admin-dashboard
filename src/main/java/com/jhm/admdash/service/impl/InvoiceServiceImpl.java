package com.jhm.admdash.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.Invoice;
import com.jhm.admdash.service.InvoiceService;

@Repository
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public Invoice getInvoice(Long id) {
		return null;
	}

	@Override
	public boolean addInvoice(Invoice invoice) {
		return false;
	}

	@Override
	public boolean updateInvoice(Invoice invoice) {
		return false;
	}

	@Override
	public boolean deleteInvoice(Long id) {
		return false;
	}


}
