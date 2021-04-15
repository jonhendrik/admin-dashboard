package com.jhm.admdash.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.Account;
import com.jhm.admdash.model.Customer;
import com.jhm.admdash.model.Invoice;
import com.jhm.admdash.model.dto.AccountDto;
import com.jhm.admdash.model.dto.CustomerDto;
import com.jhm.admdash.model.dto.InvoiceDto;
import com.jhm.admdash.repository.AccountRepository;
import com.jhm.admdash.service.AccountService;

@Repository
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<AccountDto> getAccounts() {	
		List<Account> accounts = (List<Account>) accountRepository.findAll();
		List<AccountDto> outDto = new ArrayList<AccountDto>();
		for (Account account : accounts) {
			AccountDto accountDto = new AccountDto();
			accountDto.setId(account.getId());
			accountDto.setDescription(account.getDescription());
			accountDto.setName(account.getName());
			accountDto.setOwnedBy(account.getOwnedBy());
			
			List<Customer> custList = account.getCustomerList();
			List<CustomerDto> custOutDto = new ArrayList<CustomerDto>();
			for (Customer cust : custList) {
				CustomerDto custDto = new CustomerDto();
				custDto.setId(cust.getId());
				custDto.setName(cust.getName());
				
				List<Invoice> invList = cust.getInvoiceList();
				List<InvoiceDto> invOutDto = new ArrayList<InvoiceDto>();
				
				for (Invoice inv : invList) {
					InvoiceDto invDto = new InvoiceDto();
					invDto.setId(inv.getId());
					invDto.setDescription(inv.getDescription());
					invDto.setPurchaseDate(inv.getPurchaseDate());
					invDto.setPurchasePrice(inv.getPurchasePrice());
					invDto.setCustomerId(cust.getId());
					
					invOutDto.add(invDto);
				}
				
				custDto.setInvoiceList(invOutDto);
				custOutDto.add(custDto);
			}
			
			accountDto.setCustomerList(custOutDto);
			outDto.add(accountDto);
		}
		
		return outDto;
	}

}
