package com.ceking.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/spring/boot/hello")
	public String hello() {
		return "hello spring boot!!!";
	}
}
