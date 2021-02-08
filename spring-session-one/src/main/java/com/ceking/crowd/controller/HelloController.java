package com.ceking.crowd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/test/spring/session/save")
	public String testSession(HttpSession session){
		session.setAttribute("king", "hello key!");
		return "数据存入到session!";
	}
}
