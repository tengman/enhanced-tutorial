package com.tete.tutorial.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tete.tutorial.common.LoginHandler;
import com.tete.tutorial.service.IUserService;

/**
 * 登录的controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest req){
		String login = LoginHandler.login(req);
		return login;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	@ResponseBody
	public String logout(HttpServletRequest req){
		String login = LoginHandler.login(req);
		return login;
	}
	
	/**
	 * 主页
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/home")
	public String home(HttpServletRequest req){
		//根据此账户的对应权限动态生成home页面
		Subject subject = SecurityUtils.getSubject();
		boolean authenticated = subject.isAuthenticated();
		if(authenticated){
			String principal = (String) subject.getPrincipal();
			boolean createHomePage = userService.createHomePage(principal,req);
			if(createHomePage){
				return "home";
			}
		}
		return "redirect:/login.jsp";
	}
	

}
