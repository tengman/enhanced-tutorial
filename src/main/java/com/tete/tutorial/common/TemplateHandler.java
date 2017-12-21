package com.tete.tutorial.common;

import java.util.Map;

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

	
	
	private boolean updateBase(Map<String, Object> datas,String fname,String path){
		return FreeMarkerUtil.filePrint(datas, fname, path);
	}
	
	public boolean updateHomeTemplate(Map<String, Object> datas,String path){
		return FreeMarkerUtil.filePrint(datas, FNAME_HOME,path);
	}

}
