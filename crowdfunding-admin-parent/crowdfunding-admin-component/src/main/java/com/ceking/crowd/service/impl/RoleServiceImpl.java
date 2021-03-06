package com.ceking.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceking.crowd.entity.Role;
import com.ceking.crowd.entity.RoleExample;
import com.ceking.crowd.entity.RoleExample.Criteria;
import com.ceking.crowd.mapper.RoleMapper;
import com.ceking.crowd.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	public PageInfo<Role> getPageInfo(String keyWord, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Role> roles = roleMapper.selectRoleByKeyWord(keyWord);
		System.out.println("");
		return new PageInfo<Role>(roles);
	}

	public void save(Role role) {
		roleMapper.insert(role);		
	}
	
	public void update(Role role) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(role.getId());
		roleMapper.updateByExample(role, example);
	}

	public void delete(Integer id) {
		
		roleMapper.deleteByPrimaryKey(id);
		
	}

	public void deleteBatch(List<Integer> idList) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(idList);		
		roleMapper.deleteByExample(example);
	}

	public List<Role> getAssignedRole(Integer adminId) {		
		return roleMapper.selectAssignRole(adminId);
	}

	public List<Role> getUnAssignedRole(Integer adminId) {
		return roleMapper.selectUnAssignRole(adminId);
	}

	public void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList) {
		//先删除旧的数据，再保存新的数据
		roleMapper.deleteRelationship(adminId);
		//保存新的数据
		if(roleIdList!=null && roleIdList.size()>0){
			roleMapper.insertRelationship(adminId,roleIdList);
		}
		
	}

}
