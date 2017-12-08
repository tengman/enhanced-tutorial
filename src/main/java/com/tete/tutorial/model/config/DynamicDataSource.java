package com.tete.tutorial.model.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源处理，利用spring自带的
 * 
 * @author tengman
 * @date 2017年5月27日 下午5:00:47
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDbType();
	}
}
