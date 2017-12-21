package com.tete.tutorial.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * 登录助手
 * @author admin
 *
 */
public class LoginHandler {
	/**
	 * 登录方法
	 * @param req
	 */
	public static String login(HttpServletRequest req){
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(name, pwd);
		try {
			subject.login(token);
			return "ok";
		} catch (Exception e) {
			if(e instanceof IncorrectCredentialsException){
				return "密码错误";
			}
			return e.getMessage();
		}
	}

}
