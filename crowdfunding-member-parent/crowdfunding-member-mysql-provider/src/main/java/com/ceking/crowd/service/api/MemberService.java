package com.ceking.crowd.service.api;

import com.ceking.crowd.entity.po.MemberPO;

public interface MemberService {

	MemberPO getMemberPOByLoginAcct(String loginacct);

	void saveMember(MemberPO memberPO);
	
}
