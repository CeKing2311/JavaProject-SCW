package com.ceking.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ceking.crowd.entity.Admin;
import com.ceking.crowd.entity.Role;
import com.ceking.crowd.mapper.AdminMapper;
import com.ceking.crowd.mapper.RoleMapper;
import com.ceking.crowd.service.api.AdminService;
import com.ceking.crowd.service.api.RoleService;
import com.ceking.crowd.util.CrowdUtil;

//Spring����Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-persist-mybatis.xml","classpath:spring-persisit-tx.xml" })
public class CrowdTest {
	
	@Autowired
	private DataSource datasource;

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMapper roleMapper;
	
	
	@Test
	public void testRole() {
		for (int i = 0; i < 63; i++) {
			Role role =new Role(null, "role"+i);
			roleMapper.insert(role);
		}
	}
	
	@Test
	public void testAdminTx(){
		
		for (int i = 0; i < 100; i++) {
			Admin admin = new Admin(null, "Marry"+i,CrowdUtil.md5Encryption( "123456"), "Marry"+i, "Marry"+i+"@qq.com", null);
			adminService.saveAdmin(admin);		
		}
	}
	
	@Test
	public void testLog() {
		Logger logger = LoggerFactory.getLogger(CrowdTest.class);
		logger.debug("debug level!");
		logger.info("info level!!!");
		logger.warn("wram level!");
		logger.info("adminService:"+adminService);
	}
	
	
	@Test
	public void testAdmin() {
		Admin admin = new Admin(null, "tom", "tom", "����Ա", "tom@qq.com", null);
		int count = adminMapper.insert(admin);
		System.out.println("******��Ӱ�������:" + count);
	}

	@Test
	public void testConnection() throws SQLException {
		Connection connection = datasource.getConnection();
		System.out.println(connection);
	}
}
