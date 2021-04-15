package com.jhm.admdash.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.Account;
import com.jhm.admdash.model.Customer;
import com.jhm.admdash.model.Invoice;
import com.jhm.admdash.model.dto.CustomerDto;
import com.jhm.admdash.model.dto.InvoiceDto;
import com.jhm.admdash.repository.AccountRepository;
import com.jhm.admdash.repository.CustomerRepository;
import com.jhm.admdash.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public CustomerDto getCustomer(Long id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		CustomerDto dto = new CustomerDto();
		if (customer != null) {
			dto.setId(customer.getId());
			dto.setName(customer.getName());
			dto.setAccountId(customer.getAccount().getId());
			
			List<Invoice> invList = customer.getInvoiceList();
			List<InvoiceDto> invOutDto = new ArrayList<InvoiceDto>();
			
			for (Invoice inv : invList) {
				InvoiceDto invDto = new InvoiceDto();
				invDto.setId(inv.getId());
				invDto.setDescription(inv.getDescription());
				invDto.setPurchaseDate(invDto.getPurchaseDate());
				invDto.setPurchasePrice(invDto.getPurchasePrice());
				
				invOutDto.add(invDto);
			}
			
			dto.setInvoiceList(invOutDto);
		}
		return dto;
	}

	@Override
	public boolean addCustomer(CustomerDto dto) {
		Customer customer = new Customer();
		Account account = accountRepository.findById(dto.getAccountId()).orElse(null);
		customer.setAccount(account);
		customer.setName(dto.getName());
		customerRepository.save(customer);
		return true;
	}

	@Override
	public boolean updateCustomer(CustomerDto dto) {
		boolean updated = false;
		Customer customerEntity = customerRepository.findById(dto.getId()).orElse(null);
		if (customerEntity != null) {
			Account account = accountRepository.findById(dto.getAccountId()).orElse(null);
			customerEntity.setAccount(account);
			customerEntity.setName(dto.getName());
			
			customerRepository.save(customerEntity);
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteCustomer(Long id) {
		boolean deleted = false;
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer != null) {
			customerRepository.delete(customer);
			deleted = true;
		}
		return deleted;
	}

}
