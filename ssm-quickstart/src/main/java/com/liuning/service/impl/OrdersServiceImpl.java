package com.liuning.service.impl;

import com.liuning.mapper.OrdersMapper;
import com.liuning.pojo.Orders;
import com.liuning.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersMapper ordersMapper;

	@Override
	public void save(Orders order) {
		// TODO Auto-generated method stub
		//ordersMapper.saveOrders(order);
	}
	
}
