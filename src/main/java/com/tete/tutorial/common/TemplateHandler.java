package com.tete.tutorial.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.tete.tutorial.util.FreeMarkerUtil;

/**
 * 模板生成辅助类
 * @author admin
 *
 */
@Component
public class TemplateHandler {
	
	private static final String FNAME_HOME="homeNav.ftlh";

	
	public boolean updateHomeTemplate(Map<String, Object> datas,String path,HttpServletRequest req){
		return FreeMarkerUtil.filePrint(datas, FNAME_HOME,path,req);
	}

}
