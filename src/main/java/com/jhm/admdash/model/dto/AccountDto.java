package com.jhm.admdash.model.dto;

import java.util.List;

public class AccountDto {

	private Long id;
    private String name;
    private String description;
    private List<CustomerDto> customerList;
    private String ownedBy;
    
    public AccountDto() {
    	
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

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CustomerDto> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerDto> customerList) {
		this.customerList = customerList;
	}

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
    
}
