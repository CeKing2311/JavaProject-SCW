package com.ceking.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceking.spring.entity.Employee;

//这是一个配置类
@Configuration
public class MyAnnotaionConfiguration {
	
	@Bean
	public Employee getEmployee() {
		return new Employee();
	}
}
