package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.TakesMapper;
import com.tete.tutorial.model.entity.Takes;
import com.tete.tutorial.service.ITakesService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-05
 */
@Service
public class TakesServiceImpl extends ServiceImpl<TakesMapper, Takes> implements ITakesService {
	
}
