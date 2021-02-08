package com.ceking.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceking.crowd.entity.po.MemberPO;
import com.ceking.crowd.entity.po.MemberPOExample;
import com.ceking.crowd.entity.po.MemberPOExample.Criteria;
import com.ceking.crowd.mapper.MemberPOMapper;
import com.ceking.crowd.service.api.MemberService;

@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberPOMapper memberPOMapper;
	
	
	@Override
	public MemberPO getMemberPOByLoginAcct(String loginacct) {
		MemberPOExample example = new MemberPOExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andLoginacctEqualTo(loginacct);
		List<MemberPO> list = memberPOMapper.selectByExample(example);
		MemberPO memberPO = list.get(0);
		return memberPO;
	}
}
