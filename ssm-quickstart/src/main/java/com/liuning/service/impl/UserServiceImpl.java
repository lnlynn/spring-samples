package com.liuning.service.impl;

import com.liuning.mapper.UserMapper;
import com.liuning.pojo.User;
import com.liuning.service.UserService;
import com.liuning.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User findUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}

	@Override
	public User findUserByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findUserByUsername(username);
	}

	@Override
	public void insertUser(User user) throws Exception {
		
		user.setState(0);//0:代表用户未激活   1：代表用户已经激活
		
		String code = UUIDUtils.getUUID();
		user.setCode(code);
		
		userMapper.insertUser(user);
	}

}
