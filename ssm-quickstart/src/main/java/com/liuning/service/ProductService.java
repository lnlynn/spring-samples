package com.liuning.service;

import com.liuning.pojo.Product;

import java.util.List;

public interface ProductService {

	//查询热门商品
	public List<Product> findHotProductList() throws Exception;

	//查询最新商品
	public List<Product> findNewProductList() throws Exception;

	//根据商品id查询商品
	public Product findProductById(Integer pid) throws Exception;

}
