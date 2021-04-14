package com.jhm.admdash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhm.admdash.model.User;
import com.jhm.admdash.repository.UserRepository;
import com.jhm.admdash.service.LoginService;

@Repository
public class LoginServiceImpl implements LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean authUser(String username, String password) {
		log.info("start authUser ");
		boolean isAuthUser = false;
		List<User> userList = userRepository.findByNameAndPassword(username, password);
		if (userList.size() > 0) {
			isAuthUser = true;
		}
		log.info("isAuthUser : " + isAuthUser);
		return isAuthUser;
	}

}
