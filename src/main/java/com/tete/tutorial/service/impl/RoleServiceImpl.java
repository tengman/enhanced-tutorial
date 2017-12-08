package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.RoleDao;
import com.tete.tutorial.model.entity.Role;
import com.tete.tutorial.service.IRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements IRoleService {
	
}
