package com.ceking.crowd.service.api;

import java.util.List;
import java.util.Map;

import com.ceking.crowd.entity.Auth;

public interface AuthService {

	List<Auth> getAllAuth();

	List<Integer> getAuthByRoleId(Integer roleId);

	void saveAuthRoleRelationship(Map<String, List<Integer>> map);

	List<String> getAuthNameByAdminId(Integer adminId);
}
