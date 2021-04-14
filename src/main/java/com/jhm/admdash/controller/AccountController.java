package com.jhm.admdash.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhm.admdash.model.Account;
import com.jhm.admdash.model.Customer;
import com.jhm.admdash.model.Invoice;
import com.jhm.admdash.model.dto.AccountDto;
import com.jhm.admdash.model.dto.CustomerDto;
import com.jhm.admdash.model.dto.InvoiceDto;
import com.jhm.admdash.service.AccountService;

@RestController
@RequestMapping(value="/api")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/accounts", method = RequestMethod.GET)
	public List<AccountDto> getAccounts(){
		
		List<Account> accounts = accountService.getAccounts();
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
					invDto.setPurchaseDate(invDto.getPurchaseDate());
					invDto.setPurchasePrice(invDto.getPurchasePrice());
					
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
