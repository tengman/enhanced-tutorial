package com.tete.tutorial.model.config;
/**
 * 数据源上下文
* @author tengman  
* @date 2017年5月27日 下午5:06:20
 */
public class DbContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	/**
	 * 设置数据源
	 * 
	 * @param dbTypeEnum
	 */
	public static void setDbType(DBTypeEnum dbTypeEnum) {
		contextHolder.set(dbTypeEnum.getValue());
	}

	/**
	 * 取得当前数据源
	 * 
	 * @return
	 */
	public static String getDbType() {
		return contextHolder.get();
	}

	/**
	 * 清除上下文数据
	 */
	public static void clearDbType() {
		contextHolder.remove();
	}
}
