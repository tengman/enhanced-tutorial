package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.SpecialityMapper;
import com.tete.tutorial.model.entity.Speciality;
import com.tete.tutorial.service.ISpecialityService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-05
 */
@Service
public class SpecialityServiceImpl extends ServiceImpl<SpecialityMapper, Speciality> implements ISpecialityService {
	
}
