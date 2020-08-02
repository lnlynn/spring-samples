package com.liuning.controller;

import com.liuning.model.Cart;
import com.liuning.model.CartItem;
import com.liuning.pojo.Orders;
import com.liuning.pojo.OrdersItem;
import com.liuning.pojo.User;
import com.liuning.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class OrdersController {
	
	@Autowired
	OrdersService orderService;

	private Orders order = new Orders();
	
	
	// 生成订单的执行的方法:
	@RequestMapping("/saveOrders")
	public String saveOrder(HttpServletRequest request,HttpSession session) {

		// 调用Service完成数据库插入的操作:
		
		// 设置订单的总金额:订单的总金额应该是购物车中总金额:
		// 购物车在session中,从session总获得购物车信息.
		Cart cart = (Cart) session.getAttribute("cart");
		
		order.setTotal(cart.getTotal());
		// 设置订单的状态
		order.setState(1); // 1:未付款.2:已经付款，但未发货 3:已经发货但未收到 4：订单已完成
		// 设置订单时间
		order.setOrdertime(new Date());
		
		// 设置订单关联的客户:
		User existUser = (User) session.getAttribute("user");
		if(existUser == null) {
			return "login";
		}
		order.setUser(existUser);
		
		// 设置订单项集合:
		for (CartItem cartItem : cart.getCartItems()) {
			// 订单项的信息从购物项获得的.
			OrdersItem orderItem = new OrdersItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrders(order);
			
			order.getOrdersItems().add(orderItem);
		}
		
		orderService.save(order);
		// 清空购物车:
		cart.clearCart();
	
		// 页面需要回显订单信息:
		request.setAttribute("order", order);
		// 使用模型驱动了 所有可以不使用值栈保存了
		// ActionContext.getContext().getValueStack().set("order", order);
	
		return "orders";
	}
	
	@RequestMapping("/queryOrders")
	public String queryOrders(String id) {
		return "orders";
	}
	
}
