package com.ceking.crowd.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceking.crowd.entity.Auth;
import com.ceking.crowd.entity.Role;
import com.ceking.crowd.service.api.AdminService;
import com.ceking.crowd.service.api.AuthService;
import com.ceking.crowd.service.api.RoleService;
import com.ceking.crowd.util.ResultEntity;

@Controller
public class AssignController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthService authService;

	
	@ResponseBody
	@RequestMapping("/assign/do/role/assign/auth.json")
	public ResultEntity<String> saveAuthRoleRelationship(@RequestBody Map<String, List<Integer>> map){
		
		authService.saveAuthRoleRelationship(map);
		return ResultEntity.successWithoutData();		
	}
	
	@ResponseBody
	@RequestMapping("/assign/get/assigned/auth/role/id.json")
	public ResultEntity<List<Integer>> getAuthByRoleId(@RequestParam("roleId") Integer roleId) {
		List<Integer> lists = authService.getAuthByRoleId(roleId);
		return ResultEntity.successWithData(lists);
	}
	
	@ResponseBody
	@RequestMapping("/assign/get/all/auth.json")
	public ResultEntity<List<Auth>> getAllAuth() {
		List<Auth> lists = authService.getAllAuth();
		return ResultEntity.successWithData(lists);
	}

	@RequestMapping("/assign/to/assign/role/page.html")
	public String toAssignRolePage(@RequestParam("adminId") Integer adminId, ModelMap modelMap) {
		// 已分配的角色
		List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
		// 未分配的角色
		List<Role> unAssignedRoleList = roleService.getUnAssignedRole(adminId);
		// 存入模型
		modelMap.addAttribute("assignedRoleList", assignedRoleList);
		modelMap.addAttribute("unAssignedRoleList", unAssignedRoleList);
		return "views/assign/assign-role";
	}

	/**
	 * 保存关系
	 * 
	 * @param roleIdList
	 * @param adminId
	 * @param pageNum
	 * @param keyWord
	 * @return
	 */
	@RequestMapping("/assign/do/role/assign.html")
	public String saveAdminRoleRelationship(
			@RequestParam(value = "roleIdList", required = false) List<Integer> roleIdList,
			@RequestParam("adminId") Integer adminId, @RequestParam("pageNum") Integer pageNum,
			@RequestParam("keyWord") String keyWord) {

		roleService.saveAdminRoleRelationship(adminId, roleIdList);

		return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyWord=" + keyWord;
	}

}
