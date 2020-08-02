package com.liuning.controller;

import com.liuning.pojo.User;
import com.liuning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * 用户登陆验证程序
	 * @param username	: 页面传回的用户姓名
	 * @param password	: 页面传回的用户密码
	 * @param checkcode : 页面传回的验证码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password,String checkcode)
			throws Exception {
		
		//判断验证码程序
		//从session中获得验证码的随机值
		String checkcode2 = (String) session.getAttribute("checkcode");
			if(!checkcode.equalsIgnoreCase(checkcode2)) {
				return "login";
		}
		
		User user = userService.findUserByUsername(username);
		
		if(password.equals(user.getPassword())) {
			//在session中保存用户身份信息
			session.setAttribute("user", user);
			return "redirect:index.action";
		}
		
		return "redirect:index.action";
	}

	/**
	 * 用户退出登录
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:index.action";
	}
	
	/**
	 * AJAX进行异步校验用户名的执行方法
	 * @param response
	 * @param username
	 * @throws Exception
	 */
	@RequestMapping("/user_findByName")
	public void findUserByName(HttpServletResponse response,String username) throws Exception {
		
		User existUser = userService.findUserByUsername(username);
		
		response.setContentType("text/html;charset=UTF-8");
		
		if(existUser != null) {
			//查询到用户：用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else {
			//没查询到用户：用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
	}
	
	/**
	 * 用户注册的方法
	 * @param user		: 页面传回的用户注册信息(springmvc自动参数绑定)
	 * @param checkcode	: 页面传回的验证码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/user_register")
	public String userRegister(HttpSession session,User user,String checkcode) throws Exception {
		
		//判断验证码程序
		//从session中获得验证码的随机值
		String checkcode1 = (String) session.getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)) {
			return "register";
		}
		
		userService.insertUser(user);
		
		return "msg";
	}
}
