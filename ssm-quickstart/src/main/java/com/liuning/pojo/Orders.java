package com.liuning.pojo;

import java.util.HashSet;
import java.util.Set;

public class Orders {

	private Integer oid;
	private Double total;
	private java.util.Date ordertime;
	private Integer state;
	private String name;
	private String phone;
	private String addr;
	//订单所属的用户
	private User user;
	//订单中所属的多个订单项
	private Set<OrdersItem> ordersItems = new HashSet<OrdersItem>();
	
	
	
	public Set<OrdersItem> getOrdersItems() {
		return ordersItems;
	}
	public void setOrdersItems(Set<OrdersItem> ordersItems) {
		this.ordersItems = ordersItems;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public java.util.Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(java.util.Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
