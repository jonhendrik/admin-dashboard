package com.jhm.admdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhm.admdash.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

    @RequestMapping("/")
    public String login() {
        return "login";
    }
    
    @RequestMapping(value="/dashboard", method = RequestMethod.POST)
	public String showDashoard(ModelMap model, @RequestParam String username, @RequestParam String password){
    	String passwordHex = DigestUtils.md5DigestAsHex(password.getBytes());
		boolean isAuthUser = loginService.authUser(username, passwordHex);
		
		if (!isAuthUser) {
			model.put("errorMessage", "Invalid Username or Password");
			return "login";
		}
		
		model.put("username", username);
		model.put("password", password);
		
		return "dashboard";
	}
    
    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String showDashboard(ModelMap model){
		return "dashboard";
	}
}
