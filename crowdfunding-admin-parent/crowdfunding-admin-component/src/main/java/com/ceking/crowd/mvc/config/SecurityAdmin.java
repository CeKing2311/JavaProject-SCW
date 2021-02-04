package com.ceking.crowd.mvc.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ceking.crowd.entity.Admin;

/**
 * User中仅包含账号和密码，为了获取到原始的Admin对象，专门创建此类来继承User类进行扩展
 * @author cjq
 *
 */
public class SecurityAdmin extends User{

	private static final long serialVersionUID = 1L;
	
	private Admin originalAdmin;
	
	public SecurityAdmin(Admin originalAdmin, List<GrantedAuthority> authorities) {
		
		super(originalAdmin.getLoginAcct(), originalAdmin.getUserPswd(), authorities);
		
		this.originalAdmin =originalAdmin;
		//将原始密码清除，避免系统漏洞，增加安全性
		this.originalAdmin.setUserPswd(null);
	}
	public Admin getOriginalAdmin() {
		return originalAdmin;
	}
	
	
	
	
}
