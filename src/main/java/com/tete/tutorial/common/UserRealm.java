package com.tete.tutorial.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.tete.tutorial.model.entity.Resource;
import com.tete.tutorial.model.entity.Role;
import com.tete.tutorial.model.entity.User;
import com.tete.tutorial.service.IResourceService;
import com.tete.tutorial.service.IRoleService;
import com.tete.tutorial.service.IUserService;
import com.tete.tutorial.util.shiroUtil;

/**
 * 
 * @author tengman
 *
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourceService;
    
    private static final char ONE='1';
//    private static final char ZERO='0';
    

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       //判断授权的
    	String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Wrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("name", username);
		User user = userService.selectOne(wrapper);
		String roleIds = user.getRoleIds();
		Wrapper<Role> wrapperr = new EntityWrapper<>();
		wrapperr.in("id", roleIds.split(","));
		List<Role> selectList = roleService.selectList(wrapperr);
		Set<String> roles = new HashSet<>();
		Set<String> resourceList = new HashSet<>();
		for (Role role : selectList) {
			List<String> asList = Arrays.asList(role.getResourceIds().split(","));
			resourceList.addAll(asList);
			roles.add(role.getRole());
		}
		List<Resource> selectBatchIds = resourceService.selectBatchIds(new ArrayList<>(resourceList));
		Set<String> permissions = new HashSet<>();
		for (Resource resource : selectBatchIds) {
			Integer operation = resource.getOperation();
			if(operation != 0){
				String intToBinary = shiroUtil.IntToBinary(operation);
				char[] charArray = intToBinary.toCharArray();
				if(charArray[0]==ONE){
					permissions.add(resource.getUrl()+"/add*");	
				}
				if(charArray[1]==ONE){
					permissions.add(resource.getUrl()+"/delete");	
				}
				if(charArray[2]==ONE){
					permissions.add(resource.getUrl()+"/update*");	
				}
				if(charArray[3]==ONE){
					permissions.add(resource.getUrl()+"/list");	
				}
			}
		}
//		authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	//判断认证的
        String username = (String)token.getPrincipal();

        Wrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("name", username);
		User user = userService.selectOne(wrapper);
        if(user == null) {
            throw new UnknownAccountException("账户不存在");//没找到帐号
        }
        if(user.getState()==-1) {
            throw new LockedAccountException("账号已被锁定"); //帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getName(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(username),//salt=username
                getName()  //realm name
        );
        return authenticationInfo;
    }

    
    public static void main(String[] args) {
    	List<String> list = new ArrayList<>();
    	list.add("1");
    	list.add("2");
    	list.add("3");
    	list.add("4");
    	Map<String,Object> map = new HashMap<>();
    	map.put("name", "tete");
    	map.put("url", "http://baidu.com");
    	map.put("desc", "百度");
    	map.put("all", list);
//    	FreeMarkerUtil.filePrint(null, "login.ftlh", "login.jsp");
//    	TemplateHandler templateHandler = new TemplateHandler();
//    	templateHandler.updateHomeTemplate(null);
	}

}
