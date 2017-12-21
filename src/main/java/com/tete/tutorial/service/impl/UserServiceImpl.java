package com.tete.tutorial.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.common.TemplateHandler;
import com.tete.tutorial.model.dao.UserDao;
import com.tete.tutorial.model.entity.Resource;
import com.tete.tutorial.model.entity.Role;
import com.tete.tutorial.model.entity.User;
import com.tete.tutorial.service.IResourceService;
import com.tete.tutorial.service.IRoleService;
import com.tete.tutorial.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IResourceService resourceService;
	@Autowired
	private TemplateHandler templateHandler;
	
	
	@Override
	public boolean createHomePage(String name,HttpServletRequest req) {
		User entity = new User();
		entity.setName(name);
		User user = userDao.selectOne(entity);
		String roleIds = user.getRoleIds();
		List<Role> selectBatchIds = roleService.selectBatchIds(Arrays.asList(roleIds.split(",")));
		//得到当前用户的所有资源集合
		List<Resource> resources = new ArrayList<>();
		for (Role role : selectBatchIds) {
			String resourceIds = role.getResourceIds();
			List<Resource> list = resourceService.selectBatchIds(Arrays.asList(resourceIds.split(",")));
			resources.addAll(list);
		}
		//分出菜单和子菜单
		List<Resource> results = new ArrayList<>();
		results.addAll(resources);
		for (Resource resource : resources) {
			Integer parentId = resource.getParentId();
			if(parentId != null){
				for (Resource resource2 : results) {
					if(parentId.equals(resource2.getId())){
						resource2.setResources(resource);
					}
				}
			}
		}
			
		Map<String, Object> datas = new HashMap<>();
		datas.put("root", results);
		String contextPath = req.getServletContext().getRealPath("/WEB-INF/view/");
		return templateHandler.updateHomeTemplate(datas,contextPath+"homeNav.jsp");
	}

	
}
