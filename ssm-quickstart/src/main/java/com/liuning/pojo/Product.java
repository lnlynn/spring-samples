package com.liuning.pojo;

public class Product {

	private Integer pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String pdesc;
	private Integer is_hot;
	private java.util.Date pdate;

	//二级分类的对象：使用二级分类的对象
	private CategorySecond categorySeconds;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public java.util.Date getPdate() {
		return pdate;
	}
	public void setPdate(java.util.Date pdate) {
		this.pdate = pdate;
	}
	public CategorySecond getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(CategorySecond categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	@Override
	public String toString() {
		return "Product{" +
				"pid=" + pid +
				", pname='" + pname + '\'' +
				", market_price=" + market_price +
				", shop_price=" + shop_price +
				", image='" + image + '\'' +
				", pdesc='" + pdesc + '\'' +
				", is_hot=" + is_hot +
				", pdate=" + pdate +
				", categorySeconds=" + categorySeconds +
				'}';
	}
}
