package com.ceking.crowd.service.api;

import java.util.List;

import com.ceking.crowd.entity.Menu;

public interface MenuService {

	List<Menu> getAll();

	void save(Menu menu);

	void update(Menu menu);

	void delete(Integer id);
	
}
