package com.ceking.security.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {

		return MD5Encoding(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		//明文加密密码
		String encoding = MD5Encoding(rawPassword);
		System.out.println("encoding:"+encoding);
		System.out.println("encodedPassword:"+encodedPassword);
		//密码比较
		return Objects.equals(encoding, encodedPassword);
	}

	private String MD5Encoding(CharSequence rawPassword) {
		try {
			// 1.创建MessageDigest对象
			String algorithm = "MD5";
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			// 2.获取rawPassword字节数组
			byte[] input = ((String) rawPassword).getBytes();
			// 3.加密
			byte[] output = digest.digest(input);
			// 4.转换为16进制数对应的字符
			String encoded = new BigInteger(1, output).toString(16);
			
			return encoded.toUpperCase();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
