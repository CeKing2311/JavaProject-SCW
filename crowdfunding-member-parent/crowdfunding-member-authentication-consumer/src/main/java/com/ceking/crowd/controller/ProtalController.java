package com.ceking.crowd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProtalController {
	
	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("/")
	public String showProtalPage(){
		
		return "protal";
	}
	
	
	
}