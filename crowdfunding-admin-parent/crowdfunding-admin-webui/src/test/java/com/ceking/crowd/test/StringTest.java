package com.ceking.crowd.test;

import org.junit.Test;

import com.ceking.crowd.util.CrowdUtil;

public class StringTest {

	@Test
	public void testMd5(){
		String source ="123456";
		String encryption = CrowdUtil.md5Encryption(source);
		System.out.println(encryption);
	}
}
