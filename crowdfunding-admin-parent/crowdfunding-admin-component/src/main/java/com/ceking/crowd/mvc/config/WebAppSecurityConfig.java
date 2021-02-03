package com.ceking.crowd.mvc.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity	//启用web环境下权限控制功能 
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		
		builder
			.inMemoryAuthentication()
			.withUser("admin").password("123456").roles("ADMIN");			
	}
	
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
		security
			.authorizeRequests()							  //对请求授权
			.antMatchers("/admin/to/login/page.html").permitAll()  //登录页放行，无条件访问
			.antMatchers("/bootstrap/**").permitAll()         //登录页放行，无条件访问
			.antMatchers("/crowd/**").permitAll()             //登录页放行，无条件访问
			.antMatchers("/css/**").permitAll()               //登录页放行，无条件访问
			.antMatchers("/fonts/**").permitAll()             //登录页放行，无条件访问
			.antMatchers("/img/**").permitAll()               //登录页放行，无条件访问
			.antMatchers("/jquery/**").permitAll()            //登录页放行，无条件访问
			.antMatchers("/layer/**").permitAll()             //登录页放行，无条件访问
			.antMatchers("/script/**").permitAll()            //登录页放行，无条件访问
			.antMatchers("/ztree/**").permitAll()             //登录页放行，无条件访问
			.anyRequest()		//其他任意请求
			.authenticated()	//认证后访问							  
			.and()
			.csrf()				//放跨站请求伪造功能
			.disable()			//禁用
			.formLogin()										//开启表单登录功能
			.loginPage("/admin/to/login/page.html")				//指定登录页面
			.loginProcessingUrl("security/to/login.html")		//指定处理登录请求的地址
			.defaultSuccessUrl("/admin/to/main/page.html")	//指定登录成功后跳转的地址,无需登录			
			.usernameParameter("loginAcct")						//账号的请求参数名称
			.passwordParameter("userPass")						//密码的请求参数名称
			;
		
	}
	
}
