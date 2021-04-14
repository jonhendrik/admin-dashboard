package com.jhm.admdash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.Account;
import com.jhm.admdash.repository.AccountRepository;
import com.jhm.admdash.service.AccountService;

@Repository
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> getAccounts() {
		return (List<Account>) accountRepository.findAll();
	}

}
