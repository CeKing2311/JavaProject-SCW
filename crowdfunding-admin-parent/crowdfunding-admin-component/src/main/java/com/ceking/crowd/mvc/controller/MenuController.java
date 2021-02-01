package com.ceking.crowd.mvc.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceking.crowd.entity.Menu;
import com.ceking.crowd.service.api.MenuService;
import com.ceking.crowd.util.ResultEntity;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/menu/get/menu/tree.json")
	public ResultEntity<Menu> getMenuTree(){
		List<Menu> list = menuService.getAll();
		Menu root =null;
		//创建Map对象存储id和menu对象的对应关系
		Map<Integer, Menu> menuMap =new HashMap<Integer, Menu>();
		for (Menu menu : list) {
			Integer id = menu.getId();		
			menuMap.put(id, menu);			
		}
		//查找根节点，组装父子节点
		for (Menu menu : list) {
			Integer pid = menu.getPid();
			if(pid==null){
				//根节点
				root =menu;
				//继续下一次循环
				continue;
			}
			//当前节点有父节点
			Menu father = menuMap.get(pid);
			//将当前节点存入父节点的children集合
			father.getChildren().add(menu);		
		}
		//返回数据
		return ResultEntity.successWithData(root);
	}
	
	
	/*public ResultEntity<Menu> getMenuTreeOld(){
		List<Menu> list = menuService.getAll();
		Menu root =null;
		for (Menu menu : list) {
			Integer pid = menu.getPid();
			if(pid==null){
				//根节点
				root =menu;
				//继续下一次循环
				continue;
			}
			//
			for (Menu maybeFather : list) {
				Integer id = maybeFather.getPid();
				if (Objects.equals(pid, id)) {
					//将子节点存入父节点
					maybeFather.getChildren().add(menu);
					//找到即可停止循环
					break;
				}
			}
		}
		//返回数据
		return ResultEntity.successWithData(root);
	}*/
	
	private Menu getMenu(List<Menu> menus) {
		Menu menu=null;
		return null;
	}
}
