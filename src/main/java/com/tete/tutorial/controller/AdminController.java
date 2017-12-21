package com.tete.tutorial.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tete.tutorial.model.entity.Role;
import com.tete.tutorial.model.entity.User;
import com.tete.tutorial.service.IRoleService;
import com.tete.tutorial.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	
	@RequestMapping(value="/panel/list")
	public String panelList(Model model){

		return "/admin/main";
	}
	
	//角色
	@RequestMapping(value="/role/list")
	public String roleList(Model model){
		List<Role> selectList = roleService.selectList(null);
		model.addAttribute("roleList", selectList);
		return "/admin/system/role/role";
	}
	@RequestMapping(value="/role/addPage")
	public String roleAddPage(){
		return "/admin/system/role/role_add";
	}
	@RequestMapping(value="/role/add")
	public String roleAdd(HttpServletRequest req){
		String role = req.getParameter("role");
		String desc = req.getParameter("desc");
		String resourceIds = req.getParameter("resourceIds");
		Role entity = new Role();
		entity.setDesc(desc);
		entity.setRole(role);
		entity.setResourceIds(resourceIds);
		roleService.insert(entity);
		return "redirect:/admin/role/list";
	}
	@RequestMapping(value="/role/delete")
	public String roleDelete(HttpServletRequest req){
		String id = req.getParameter("id");
		roleService.deleteById(Integer.valueOf(id));
		return "redirect:/admin/role/list";
	}
	
	//用户
	@RequestMapping(value="/user/list")
	public String userList(Model model){
		List<User> selectList = userService.selectList(null);
		model.addAttribute("userList", selectList);
		return "/admin/system/user/user";
	}
	@RequestMapping(value="/user/addPage")
	public String userAddPage(Model model){
		model.addAttribute("roleList", roleService.selectList(null));
		return "/admin/system/user/user_add";
	}
	@RequestMapping(value="/user/updatePage")
	public String userUpdatePage(HttpServletRequest req,Model model){
		String id = req.getParameter("id");
		User user = userService.selectById(id);
		model.addAttribute("user", user);
		List<String> asList = Arrays.asList(user.getRoleIds().split(","));
		List<Role> selectList = roleService.selectList(null);
		for (Role role : selectList) {
			if(asList.contains(role.getId())){
				role.setSelected(1);
			}else{
				role.setSelected(-1);
			}
		}
		model.addAttribute("roleList",selectList);
		return "/admin/system/user/user_update";
	}
	@RequestMapping(value="/user/add")
	public String userAdd(HttpServletRequest req){
		String name = req.getParameter("name");
		String password = req.getParameter("password");
        String newPassword = new SimpleHash(
                "md5",
                password,
                ByteSource.Util.bytes(name),
                1).toHex();
        User entity = new User();
		String[] roleIds = req.getParameterValues("roleIds");
		String str ="";
		for (String string : roleIds) {
			str+=string+",";
		}
		entity.setRoleIds(str.substring(0, str.lastIndexOf(",")));
		entity.setName(name);
		entity.setPassword(newPassword);
		userService.insert(entity);
		return "redirect:/admin/user/list";
	}

	@RequestMapping(value="/user/delete")
	public String userDelete(HttpServletRequest req){
		String id = req.getParameter("id");
		userService.deleteById(Integer.valueOf(id));
		return "redirect:/admin/user/list";
	}
}
