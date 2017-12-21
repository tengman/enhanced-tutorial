package com.tete.tutorial.service;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.service.IService;
import com.tete.tutorial.model.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
public interface IUserService extends IService<User> {
	/**
	 * 根据用户名查询用户的角色，根据角色得到资源集合，查出所有资源，动态创建主页
	 * @param name 用户名
	 * @return 成功失败
	 */
	public boolean createHomePage(String name,HttpServletRequest req);
	

	
}
