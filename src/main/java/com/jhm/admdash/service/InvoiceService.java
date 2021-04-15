package com.jhm.admdash.service;

import com.jhm.admdash.model.dto.InvoiceDto;

public interface InvoiceService {

	public InvoiceDto getInvoice(Long id);
	public boolean addInvoice(InvoiceDto dto);
	public boolean updateInvoice(InvoiceDto dto);
	public boolean deleteInvoice(Long id);
	
}
