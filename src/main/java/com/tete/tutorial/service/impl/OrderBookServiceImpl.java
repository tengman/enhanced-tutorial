package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.OrderBookMapper;
import com.tete.tutorial.model.entity.OrderBook;
import com.tete.tutorial.service.IOrderBookService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-05
 */
@Service
public class OrderBookServiceImpl extends ServiceImpl<OrderBookMapper, OrderBook> implements IOrderBookService {
	
}
