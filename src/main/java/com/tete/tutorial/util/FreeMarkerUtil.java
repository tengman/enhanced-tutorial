package com.tete.tutorial.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * freeMarker模板工具类
 * @author admin
 *
 */
public class FreeMarkerUtil {
	
	private static Configuration cfg = null;

	private FreeMarkerUtil() {
		super();
	}
	
	private static Configuration initInstance() throws IOException{
		if(cfg == null){
			// Create your Configuration instance, and specify if up to what FreeMarker
			// version (here 2.3.23) do you want to apply the fixes that are not 100%
			// backward-compatible. See the Configuration JavaDoc for details.
			cfg = new Configuration(Configuration.VERSION_2_3_23);
			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");
			cfg.setClassLoaderForTemplateLoading(FreeMarkerUtil.class.getClassLoader(), "com/tete/tutorial/template");
//			cfg.setDirectoryForTemplateLoading(new File("com/tete/tutorial/template/"));
			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
			cfg.setLogTemplateExceptions(false);
			// Wrap unchecked exceptions thrown during template processing into TemplateException-s.
			//		cfg.setWrapUncheckedExceptions(true);
		}
		return cfg;
	}
	
	private static Template getTemplate(String fname){
		try {
			Configuration initInstance = initInstance();
			return initInstance.getTemplate(fname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 文件输出
	 * @param datas 数据
	 * @param fname 模板名
	 * @param path 输出路径
	 * @return
	 */
	public static boolean filePrint(Map<String, Object> datas,String fname,String path){
		Template template = getTemplate(fname);
		try {
			template.process(datas, new FileWriterWithEncoding(path,"utf-8"));
			return true;
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
