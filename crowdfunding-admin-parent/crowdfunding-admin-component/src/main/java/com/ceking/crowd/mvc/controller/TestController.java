package com.ceking.crowd.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceking.crowd.entity.Admin;
import com.ceking.crowd.service.api.AdminService;

@Controller
public class TestController {

	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping("/send/array2.html")
	public String sendArray2(@RequestBody List<Integer> array) {
		System.out.println(array);
		return "suucess";
	}
	
	@ResponseBody
	@RequestMapping("/send/array.html")
	public String sendArray(@RequestParam("array[]") List<Integer> array) {
		System.out.println(array);
		return "suucess";
	}
	
	@RequestMapping("/test/ssm.html")
	public String testService(ModelMap modelMap){		
		List<Admin> lists= adminService.getAll();
		modelMap.addAttribute("adminList",lists);
		return "target";
	}
}
