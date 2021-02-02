package com.ceking.crowd.service.api;

import java.util.List;

import com.ceking.crowd.entity.Role;
import com.github.pagehelper.PageInfo;

public interface RoleService {
	PageInfo<Role> getPageInfo(String keyWord,Integer pageNum,Integer pageSize);

	void save(Role role);

	void update(Role role);

	void delete(Integer id);
	
	void deleteBatch(List<Integer> idList);

	List<Role> getAssignedRole(Integer adminId);

	List<Role> getUnAssignedRole(Integer adminId);
	
	void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);
}
