package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.ResourceTypeDao;
import com.tete.tutorial.model.entity.ResourceType;
import com.tete.tutorial.service.IResourceTypeService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-19
 */
@Service
public class ResourceTypeServiceImpl extends ServiceImpl<ResourceTypeDao, ResourceType> implements IResourceTypeService {
	
}
