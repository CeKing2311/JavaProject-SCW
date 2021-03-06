package com.ceking.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceking.crowd.entity.Menu;
import com.ceking.crowd.entity.MenuExample;
import com.ceking.crowd.entity.MenuExample.Criteria;
import com.ceking.crowd.mapper.MenuMapper;
import com.ceking.crowd.service.api.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	public List<Menu> getAll() {
		List<Menu> list = menuMapper.selectByExample(null);
		return list;
	}

	public void save(Menu menu) {
		menuMapper.insert(menu);		
	}

	public void update(Menu menu) {
		//有选择的更新
		menuMapper.updateByPrimaryKeySelective(menu);
	}

	public void delete(Integer id) {
		menuMapper.deleteByPrimaryKey(id);
	}
}
