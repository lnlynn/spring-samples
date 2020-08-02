package com.liuning.pojo;

import java.util.List;

public class CategorySecond {

	private Integer csid;
	private String csname;
	
	//所属一级分类，存的是一级分类的对象
	private Category category;
	
	//二级分类里存放Product的集合
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
