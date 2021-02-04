package com.ceking.crowd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceking.crowd.entity.Auth;
import com.ceking.crowd.entity.AuthExample;
import com.ceking.crowd.mapper.AuthMapper;
import com.ceking.crowd.service.api.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthMapper authMapper;

	public List<Auth> getAllAuth() {
		
		return authMapper.selectByExample(new AuthExample());
	}

	public List<Integer> getAuthByRoleId(Integer roleId) {
		return authMapper.selectAuthByRoleId(roleId);
	}

	public void saveAuthRoleRelationship(Map<String, List<Integer>> map) {
		//获取roleId
		List<Integer> listRoleId = map.get("roleId");
		Integer roleId =listRoleId.get(0);
		//删除旧的关联数据
		authMapper.deleteRoleAuthRelationshipByRoleId(roleId);
		List<Integer> authIdList = map.get("authIdArray");
		if(authIdList!=null && authIdList.size()>0){			
			authMapper.insertRoleAuthRelationship(roleId,authIdList);			
		}
			
	}

	@Override
	public List<String> getAuthNameByAdminId(Integer adminId) {
		return authMapper.selectAuthNameByAdminId(adminId);
	}
}
