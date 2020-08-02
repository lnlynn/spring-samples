package com.liuning.controller;

import com.liuning.model.Cart;
import com.liuning.model.CartItem;
import com.liuning.pojo.Product;
import com.liuning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	ProductService productService;
	
	/**
	 * 将购物项添加到购物车：执行的方法
	 * @param pid	: 商品的id
	 * @param count	: 购买商品的数量
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addCart")
	public String addCart(HttpSession session,String pid,String count) throws Exception {
		//封装一个CartItem对象
		CartItem cartItem = new CartItem();
		//设置数量
		cartItem.setCount(Integer.parseInt(count));
		//根据pid查询商品
		Product product = productService.findProductById(Integer.parseInt(pid));
		//设置商品
		cartItem.setProduct(product);
		//将购物项添加到购物车
		//Cart cart = new Cart();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addCart(cartItem);
		
		return "cart";
	}
	/**
	 * 清空购物车
	 * @param session
	 * @return
	 */
	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.clearCart();
		return "cart";
	}
	
	/**
	 * 移除购物车中的购物项
	 * @param session
	 * @param pid
	 * @return
	 */
	@RequestMapping("/removeCart")
	public String removeCart(HttpSession session,String pid) {
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.removeCart(Integer.parseInt(pid));
		return "cart";
	}
}
