package com.jhm.admdash.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy="id")
    private List<Customer> customerList;
    private String ownedBy;
    
    public Account() {
    	customerList = new ArrayList<Customer>();
    }
    
    public Account(String name) {
    	customerList = new ArrayList<Customer>();
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

	public String getDescription() {
		return description;
	}

	public void addCustomerList(Customer customer) {
        if (!getCustomerList().contains(customer)) {
        	getCustomerList().add(customer);
            if (customer.getAccount() != null) {
            	customer.getAccount().getCustomerList().remove(customer);
            }
            customer.setAccount(this);
        }
    }
    
    public List<Customer> getCustomerList() {
        return customerList;
    }

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}

}
