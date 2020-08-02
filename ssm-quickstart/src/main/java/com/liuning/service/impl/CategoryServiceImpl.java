package com.liuning.service.impl;

import com.liuning.mapper.CategoryMapper;
import com.liuning.pojo.Category;
import com.liuning.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAllCategoryList() throws Exception {
		// TODO Auto-generated method stub
		return categoryMapper.findCategoryList();
	}

	@Override
	public List<Category> findCategoryAndCategorySecond() throws Exception {
		// TODO Auto-generated method stub
		return categoryMapper.findCategoryAndCategorySecond();
	}

	@Override
	public Category findCategoryByCid(Integer cid) throws Exception {
		// TODO Auto-generated method stub
		return categoryMapper.findCategoryByCid(cid);
	}

}
