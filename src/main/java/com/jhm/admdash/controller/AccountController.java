package com.jhm.admdash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhm.admdash.model.Account;
import com.jhm.admdash.service.AccountService;

@Controller
@RequestMapping(value="/api")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/accounts", method = RequestMethod.GET)
	public List<Account> getAccounts(){
		
		List<Account> accounts = accountService.getAccounts();
		return accounts;
	}
}
