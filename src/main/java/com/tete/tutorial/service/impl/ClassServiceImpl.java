package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.ClassDao;
import com.tete.tutorial.model.entity.Class;
import com.tete.tutorial.service.IClassService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassDao, Class> implements IClassService {
	
}
