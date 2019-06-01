package com.uday.springBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uday.springBootApp.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login")
//	@ResponseBody
	public String login(ModelMap model) {
//		model.put("name", name);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name,@RequestParam String password){
		boolean validateUser = loginService.validateUser(name,password);
		if(validateUser) {
			model.put("name", name);
			return "welcome";
		}else {
			model.put("error", "Invalid Credentials!!!");
			return "login";
		}
		
	}
	
	@RequestMapping("/restMessage")
	@ResponseBody
	public String message() {
		return "Welcome to My First Message";
	}
	
}
