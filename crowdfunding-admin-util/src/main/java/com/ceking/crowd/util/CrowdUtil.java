package com.ceking.crowd.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import com.ceking.crowd.contant.CrowdConstant;

/**
 * 通用工具类
 * 
 * @author cjq
 *
 */
public class CrowdUtil {

	/**
	 * 判断请求类型
	 * 
	 * @param request
	 * @return
	 */
	public static boolean judgeRequestType(HttpServletRequest request) {
		String accepter = request.getHeader("Accept");
		String xRequest = request.getHeader("X-Requested-With");
		return ((accepter != null && accepter.contains("application/json"))
				|| (xRequest != null && xRequest.equals("XMLHttpRequest")));

	}

	/**
	 * MD5加密
	 * 
	 * @param source
	 * @return
	 */
	public static String md5Encryption(String source) {
		if (source == null || source.length() == 0) {
			//	无效字符串，抛出异常
			throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
		}
		//	获取MessageDigest 
		String algorithm="md5";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			
			//	获取字符串字节数组
			byte[] input = source.getBytes();
			//	执行加密
			byte[] ouput = messageDigest.digest(input);
			//	创建BigInteger对象
			int signum=1;
			BigInteger integer = new BigInteger(signum,ouput);
			
			//	按照16进制将integer的值转为字符串
			int radix=16;
			String encoded = integer.toString(radix).toUpperCase();			
			return encoded;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}