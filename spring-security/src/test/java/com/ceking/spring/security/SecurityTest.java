package com.ceking.spring.security;

import java.io.StringReader;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityTest {

	
	/**
	 * Security带盐值的加密，相同的明文每次加密结果不一样
	 */
	@Test	
	public void Encode() {
		// 1.创建BCryptPasswordEncoder对象
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 2.准备明文字符串
		String password = "123456";
		String encode = passwordEncoder.encode(password);
		System.out.println(encode);
		// $2a$10$kqpHZ2nY1p2cJJ.NbKLazuYH6xAqF1SXOGMyibsJ/Yj7XFQ5miEEK
		// $2a$10$3vFu58nQh3zhzo/WZRpBruPC1yK691RqNygYPRbs6G159CHrAG8QW
		// $2a$10$jTqo6TJ2HQV.nrF09V8QPuiz6YGF9.W0S6gG4IthyZdLCC/K8uL/e
	}

	@Test
	public void DecEncode() {
		// 1.创建BCryptPasswordEncoder对象
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 2.准备密文字符串
		String password = "123456";
		String code = "$2a$10$jTqo6TJ2HQV.nrF09V8QPuiz6YGF9.W0S6gG4IthyZdLCC/K8uL/e";
		
		boolean matches = passwordEncoder.matches(password, code);
		System.out.println("result:"+matches);
		
	}
}
