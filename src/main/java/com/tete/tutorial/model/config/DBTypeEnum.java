package com.tete.tutorial.model.config;

/**
 * 数据源(目前只有主从数据源)
 * 
 * @author tengman
 * @date 2017年5月27日 下午5:03:37
 */
public enum DBTypeEnum {
	MASTER("dataSource_Master"), SLAVE("dataSource_Slave");
	private String value;

	DBTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
