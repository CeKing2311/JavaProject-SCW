package com.ceking.crowd.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ceking.crowd.contant.CrowdConstant;
import com.ceking.crowd.entity.Admin;
import com.ceking.crowd.entity.AdminExample;
import com.ceking.crowd.entity.AdminExample.Criteria;
import com.ceking.crowd.exception.LoginAcctDuplicateException;
import com.ceking.crowd.exception.LoginFailedException;
import com.ceking.crowd.mapper.AdminMapper;
import com.ceking.crowd.service.api.AdminService;
import com.ceking.crowd.util.CrowdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ch.qos.logback.core.CoreConstants;

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

	public Admin getAdminByLoginAcct(String loginAcct, String userPass) {

		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginAcctEqualTo(loginAcct);
		List<Admin> list = adminMapper.selectByExample(example);
		// 判断是否查询到数据
		if (list == null || list.size() == 0) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}
		// 判断账号是否重复
		if (list.size() > 1) {
			throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
		}
		// 判断是否为空
		Admin admin = list.get(0);
		if (admin == null) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}
		// 判断密码是否正确
		String userPswd = admin.getUserPswd();
		String md5Encryption = CrowdUtil.md5Encryption(userPass);
		if (!Objects.equals(userPswd, md5Encryption)) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}
		return admin;
	}

	public PageInfo<Admin> selectAdminByKeyWord(String keyword, Integer pageNum, Integer pageSize) {
		// 1.开启分页功能
		PageHelper.startPage(pageNum, pageSize);
		// 2.查询数据
		List<Admin> listAdmin = adminMapper.selectAdminByKeyWord(keyword);
		// 3.封装PageInfo
		PageInfo<Admin> pageInfo = new PageInfo<Admin>(listAdmin);

		return pageInfo;
	}

	public void remove(Integer adminId) {
		adminMapper.deleteByPrimaryKey(adminId);

	}

	public Admin getAdminById(Integer adminId) {
		return adminMapper.selectByPrimaryKey(adminId);
	}

	public void updateAdmin(Admin admin) {
		//有选择的更新，对于null,不更新
		try {
			adminMapper.updateByPrimaryKeySelective(admin);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				throw new LoginAcctDuplicateException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
		}
		
	}

}
