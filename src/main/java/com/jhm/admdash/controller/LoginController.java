package com.jhm.admdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    
    @RequestMapping(value="/auth", method = RequestMethod.POST)
	public String showDashoard(ModelMap model, @RequestParam String username, @RequestParam String password){
		
		boolean isAuthUser = loginService.authUser(username, password);
		
		if (!isAuthUser) {
			model.put("errorMessage", "Invalid Username or Password");
			return "login";
		}
		
		model.put("username", username);
		model.put("password", password);
		
		return "dashboard";
	}
}
