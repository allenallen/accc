package com.accc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginLogoutController {
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
}
