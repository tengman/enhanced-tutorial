package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.ResourceDao;
import com.tete.tutorial.model.entity.Resource;
import com.tete.tutorial.service.IResourceService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, Resource> implements IResourceService {
	
}
