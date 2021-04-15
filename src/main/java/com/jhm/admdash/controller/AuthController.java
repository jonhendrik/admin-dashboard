package com.jhm.admdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhm.admdash.model.dto.UserDto;
import com.jhm.admdash.service.LoginService;

@RestController
public class AuthController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/auth", method = RequestMethod.POST)
	public boolean addCustomer(@RequestBody UserDto user){
		String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		return loginService.authUser(user.getUsername(), password);
	}
	
}
