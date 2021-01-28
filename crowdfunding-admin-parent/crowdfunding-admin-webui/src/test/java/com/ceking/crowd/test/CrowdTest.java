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
import com.ceking.crowd.mapper.AdminMapper;
import com.ceking.crowd.service.api.AdminService;

//Spring整合Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-persist-mybatis.xml","classpath:spring-persisit-tx.xml" })
public class CrowdTest {
	
	@Autowired
	private DataSource datasource;

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private AdminService adminService;
	
	@Test
	public void testAdminTx(){
		Admin admin = new Admin(null, "Jerry", "Jerry", "管理员", "Jerry@qq.com", null);
		adminService.saveAdmin(admin);		
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
		Admin admin = new Admin(null, "tom", "tom", "管理员", "tom@qq.com", null);
		int count = adminMapper.insert(admin);
		System.out.println("******受影响的行数:" + count);
	}

	@Test
	public void testConnection() throws SQLException {
		Connection connection = datasource.getConnection();
		System.out.println(connection);
	}
}
