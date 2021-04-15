package com.jhm.admdash.service;

import com.jhm.admdash.model.dto.CustomerDto;

public interface CustomerService {

	public CustomerDto getCustomer(Long id);
	public boolean addCustomer(CustomerDto dto);
	public boolean updateCustomer(CustomerDto dto);
	public boolean deleteCustomer(Long id);
	
}
