package com.jhm.admdash.model.dto;

import java.util.List;

import com.jhm.admdash.model.Invoice;

public class CustomerDto {

	private Long id;
    private String name;
    private List<InvoiceDto> invoiceList;
    private Long accountId;
    
    public CustomerDto() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InvoiceDto> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<InvoiceDto> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
}
