package com.liuning.mapper;

import com.liuning.pojo.Category;

import java.util.List;

public interface CategoryMapper {

	//根据cid查询Category信息
	public Category findCategoryByCid(Integer cid) throws Exception;
	
	//查询Category列表
	public List<Category> findCategoryList()throws Exception;
	
	//查询Category和CategorySecond（一级分类和二级分类）
	public List<Category> findCategoryAndCategorySecond() throws Exception;
	
}
