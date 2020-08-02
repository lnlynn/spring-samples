package com.liuning.mapper;

import com.liuning.pojo.User;

public interface UserMapper {
	
	//根据id查询用户信息
	public User findUserById(Integer id) throws Exception;
	
	//根据username查询用户信息
	public User findUserByUsername(String username) throws Exception;
	
	//插入用户信息
	public void insertUser(User user) throws Exception;
	
}
