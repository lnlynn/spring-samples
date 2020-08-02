package com.liuning.controller;

import com.liuning.pojo.Category;
import com.liuning.pojo.Product;
import com.liuning.service.CategoryService;
import com.liuning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description 首页的各种跳转
 * @author LiuNing
 */
@Controller
public class IndexController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	/**
	 * 首页入口
	 * @return 首页
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) throws Exception{
		
		//查询所有一级分类集合
		List<Category> cList = categoryService.findAllCategoryList();
		//将一级分类存入到Session的范围
		request.getSession().setAttribute("cList", cList);
		
		//查询热门商品
		List<Product> hList = productService.findHotProductList();
		//保存到request中（request域的生命周期最短）
		request.setAttribute("hList", hList);
		
		//查询最新商品
		List<Product> nList = productService.findNewProductList();
		//保存到request中（request域的生命周期最短）
		request.setAttribute("nList", nList);

		System.out.println(nList);
		
		return "index";
	}
	
	/**
	 * 跳转到注册界面的执行方法
	 * @return 注册界面
	 * @throws Exception
	 */
	@RequestMapping("/user_registPage")
	public String user_registPage() throws Exception {
		//仅跳转，无其他操作
		return "register";
	}
	
	/**
	 * 跳转到登陆界面的执行方法
	 * @return	登陆界面
	 * @throws Exception
	 */
	@RequestMapping("/user_loginPage")
	public ModelAndView user_loginPage() throws Exception {
		
		//仅跳转，无其他操作
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		
		return modelAndView;
	}
	
	/**
	 * 跳转到登陆界面的执行方法
	 * @return	购物车界面
	 * @throws Exception
	 */
	@RequestMapping("/myCart")
	public String myCart() {
		return "cart";
	}

}
