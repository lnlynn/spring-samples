<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/index.jsp">
					<img src="${pageContext.request.contextPath}/image/renleipic_01/logo.gif" alt="传智播客"/>
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
			</div>	
		</div>
		<div class="span10 last">
			<div class="topNav clearfix">
				<ul>
				<c:if test="${user == null }">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_registPage.action">注册</a>|
					</li>
				</c:if>
				<c:if test="${user != null }">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						${user.username } |
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/queryOrders.action?id=${user.id}">我的订单</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/logout.action">退出</a>|
					</li>
				</c:if>
					<li id="headerUsername" class="headerUsername"></li>
					<li id="headerLogout" class="headerLogout"><a>[退出]</a>|</li>
					<li><a>会员中心</a> | </li>
					<li><a>购物指南</a> | </li>
					<li><a>关于我们</a></li>
				</ul>
			</div>
			<div class="cart">
				<a  href="${pageContext.request.contextPath}/myCart.action">购物车</a>
			</div>
			<div class="phone">
				客服热线:<strong>15927552746</strong>
			</div>
		</div>
		<div class="span24">
			<ul class="mainNav">
				<li><a href="${pageContext.request.contextPath}/index.action">首页</a>|</li>	
				<c:forEach items="${cList}" var="category">
					<li><a href="${pageContext.request.contextPath }/category.action?cid=${category.cid}">${category.cname }</a>|</li>
				</c:forEach>	
			</ul>
		</div>
	</div>	