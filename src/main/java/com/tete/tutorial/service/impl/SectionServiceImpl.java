package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.SectionMapper;
import com.tete.tutorial.model.entity.Section;
import com.tete.tutorial.service.ISectionService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-05
 */
@Service
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements ISectionService {
	
}
