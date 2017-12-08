package com.tete.tutorial.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tete.tutorial.model.dao.BookDao;
import com.tete.tutorial.model.entity.Book;
import com.tete.tutorial.service.IBookService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tengman
 * @since 2017-12-08
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
	
}
