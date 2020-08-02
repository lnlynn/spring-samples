package com.liuning.mapper;

import com.liuning.pojo.Product;

import java.util.List;

public interface ProductMapper {

	//查询热门Product列表
	public List<Product> findHotProductList() throws Exception;

	//查询最新Product列表
	public List<Product> findNewProductList() throws Exception;
	
	//根据pid查询Product
	public Product findProductById(Integer pid) throws Exception;

}
