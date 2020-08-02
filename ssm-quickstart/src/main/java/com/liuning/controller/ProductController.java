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
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/productDetail")
	public String productDetail(HttpSession session,HttpServletRequest request,String pid) throws Exception {
		
		Product product = productService.findProductById(Integer.parseInt(pid));
		request.setAttribute("product", product);
		
		//查询所有的一级分类和二级分类
		List<Category> categoryList = categoryService.findCategoryAndCategorySecond();
		session.setAttribute("categoryList", categoryList);
		
		return "product";
	}
	
	//根据分类的cid查询商品
	@RequestMapping("/category")
	public ModelAndView findCategoryByCid(HttpSession session,String cid) throws Exception {
			
		//查询所有的一级分类和二级分类
		List<Category> categoryList = categoryService.findCategoryAndCategorySecond();
		session.setAttribute("categoryList", categoryList);
		
		//根据cid查询一级分类下的商品
		Category category = categoryService.findCategoryByCid(Integer.parseInt(cid));
		if(category != null) {
			session.setAttribute("category", category);
		}
		
		return new ModelAndView("productList");
	}
}
