package com.jhm.admdash.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy="id")
    private List<Invoice> invoiceList;
    
    @ManyToOne
    Account account;
    
    public Customer() {
    	
    }
    
    public Customer(String name) {
    	this.name = name;
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

	public void addInvoiceList(Invoice invoice) {
        if (!getInvoiceList().contains(invoice)) {
        	getInvoiceList().add(invoice);
            if (invoice.getCustomer() != null) {
            	invoice.getCustomer().getInvoiceList().remove(invoice);
            }
            invoice.setCustomer(this);
        }
    }
    
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
