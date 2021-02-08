package com.ceking.crowd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/test/spring/session/get")
	public String testSession(HttpSession session){
		String attribute = (String) session.getAttribute("king");
		return "获取到数据："+attribute;
	}
}
