package com.ceking.crowd.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceking.crowd.api.RedisRemoteService;
import com.ceking.crowd.contant.CrowdConstant;
import com.ceking.crowd.util.CrowdUtil;
import com.ceking.crowd.util.ResultEntity;
import com.netflix.discovery.converters.Auto;

@Controller
public class MemberController {

	@Autowired
	private RedisRemoteService redisRemoteService;

	@RequestMapping("/auth/member/send/message")
	public ResultEntity<String> sendMessage(@RequestParam("phoneNum") String phoneNum) {
		
		String sign = "【优益小C】";
		
		ResultEntity<String> resultEntity = CrowdUtil.sendCodeMessage(phoneNum, 4, sign);
		if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
			// 将验证码存入redis
			String key = CrowdConstant.REDIS_CODE_PREFIX +"_"+ phoneNum;
			String code = resultEntity.getData();
			long time = 15;
			TimeUnit timeUnit = TimeUnit.MINUTES;
			ResultEntity<String> saveCodeResult = redisRemoteService.setRedisKeyValueRemoteWithTimeOut(key, code, time,
					timeUnit);
			if (ResultEntity.SUCCESS.equals(saveCodeResult.getResult())) {
				return ResultEntity.successWithoutData();
			} else {
				return saveCodeResult;
			}
		} else {
			return resultEntity;
		}

	}
}