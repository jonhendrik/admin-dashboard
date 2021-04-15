package com.jhm.admdash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhm.admdash.model.dto.AccountDto;
import com.jhm.admdash.service.AccountService;

@RestController
@RequestMapping(value="/api")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/accounts", method = RequestMethod.GET)
	public List<AccountDto> getAccounts(){
		List<AccountDto> accounts = accountService.getAccounts();
		return accounts;
	}
}
