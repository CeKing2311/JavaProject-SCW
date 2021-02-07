package com.ceking.crowd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceking.crowd.entity.po.MemberPO;
import com.ceking.crowd.service.api.MemberService;
import com.ceking.crowd.util.ResultEntity;

@RestController
public class MemberProviderController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/get/memberpo/by/loginacct/remote")
	ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
		try {
			MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
			return ResultEntity.successWithData(memberPO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}
}