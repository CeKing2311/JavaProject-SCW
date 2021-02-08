package com.ceking.crowd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrowdWebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		//浏览器访问地址
		String urlPath="/auth/member/to/regist/page";
		//目标视图名称
		String viewName="member-regist";
		//添加view-controller
		registry.addViewController(urlPath).setViewName(viewName);
		//添加登录页
		registry.addViewController("/auth/member/to/login/page").setViewName("member-login");
		registry.addViewController("/auth/member/to/login/page").setViewName("member-login");
		registry.addViewController("/auth/member/to/center/page").setViewName("member-center");
	}
}
