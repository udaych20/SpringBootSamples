package com.uday.springBootApp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String name, String password) {
		if("uday".equalsIgnoreCase(name) && "uday".equals(password)) {
			return true;
		}else {
			return false;
		}
	}
}
