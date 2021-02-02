package com.ceking.crowd.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ceking.crowd.service.api.AuthService;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
}
