package com.tete.tutorial.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.UserDao;
import com.tete.tutorial.model.entity.User;
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
	
	@Override
	public Set<String> selectRoleIds(String name) {
		User entity = new User();
		entity.setName(name);
		User user = userDao.selectOne(entity);
		String roleIds = user.getRoleIds();
		String[] split = roleIds.split(",");
		Set<String> set = new HashSet<>();
		return set;
	}
	
}
