package com.liuning.service;

import com.liuning.pojo.User;

public interface UserService {

	/**
	 * 根据id查询用户信息
	 * @param id 用户的ID
	 * @return User
	 * @throws Exception
	 * @author LiuNing
	 */
	public User findUserById(Integer id) throws Exception;
	
	/**
	 * 根据username查询用户信息
	 * @param username 用户的username
	 * @return User
	 * @throws Exception
	 * @author LiuNing
	 */
	public User findUserByUsername(String username) throws Exception;
	
	/**
	 * 插入用户信息
	 * @param user 用户信息
	 * @return void
	 * @throws Exception
	 * @author LiuNing
	 */
	public void insertUser(User user) throws Exception;
	
}
