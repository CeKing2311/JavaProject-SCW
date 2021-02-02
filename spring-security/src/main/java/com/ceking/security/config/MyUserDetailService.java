package com.ceking.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ceking.security.entity.Admin;

@Component
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	//根据表单提交的用户名查询User对象，并装配角色、权限等信息
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//1.使用 SQL 语句根据用户名查询用户对象
		String sql = "SELECT id,loginacct,userpswd,username,email,createtime FROM t_admin WHERE loginacct = ?";
		List<Admin> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Admin.class),username);
		Admin admin = list.get(0);
		//2.设置角色权限信息
		List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		authorities.add(new SimpleGrantedAuthority("UPDATE"));
		//3.将admin对象和authorities封装到 UserDetails中
		String userpswd= admin.getUserpswd();
		return new User(username,userpswd,authorities);
	}

}
