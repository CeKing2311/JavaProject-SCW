package com.ceking.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceking.crowd.entity.Admin;
import com.ceking.crowd.entity.AdminExample;
import com.ceking.crowd.mapper.AdminMapper;
import com.ceking.crowd.service.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	public void saveAdmin(Admin admin) {
		adminMapper.insert(admin);
	}
	
	public List<Admin> getAll() {
		
		return adminMapper.selectByExample(new AdminExample());
	}	
	
	
}
