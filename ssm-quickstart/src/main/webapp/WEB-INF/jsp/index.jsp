<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>网上商城</title>
		<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.request.contextPath}/css/index.css"  rel="stylesheet" type="text/css"/>
	</head>
	
	<body>
		
		<%@ include file="head.jsp" %>
	
		<div class="container index">
			<div class="span24">
				<div id="hotProduct" class="hotProduct clearfix">
					<div class="title">
						<strong>热门商品</strong>
					</div>
					<ul class="tab">
						<li class="current"><a href="./蔬菜分类.htm?tagIds=1" target="_blank"></a></li>
						<li><a target="_blank"></a></li>
						<li><a target="_blank"></a></li>
					</ul>
					<ul class="tabContent" style="display: block;">
						<c:forEach items="${hList }" var="product">
							<li>
								<a href="${pageContext.request.contextPath}/productDetail.action?pid=${product.pid}" target="_self">
								<img src="${pageContext.request.contextPath}/${product.image}" style="display: block;"/></a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div class="span24">
				<div id="newProduct" class="newProduct clearfix">
					<div class="title">
						<strong>最新商品</strong>
						<a target="_blank"></a>
					</div>
					<ul class="tab">
						<li class="current">
							<a href="./蔬菜分类.htm?tagIds=2" target="_blank"></a>
						</li>
						<li>
							<a target="_blank"></a>
						</li>
						<li>
							<a target="_blank"></a>
						</li>
					</ul>						
					<ul class="tabContent" style="display: block;">
						<c:forEach items="${nList }" var="product">
							<li>
								<a href="${pageContext.request.contextPath}/productDetail.action?pid=${product.pid}" target="_self">
								<img src="${pageContext.request.contextPath}/${product.image}" style="display: block;"/></a>
							</li>
						</c:forEach>
					</ul>
				
				</div>
			</div>
			<div class="span24">
				<div class="friendLink">
					<dl>
						<dt>新手指南</dt>
						<dd><a target="_blank">支付方式</a>|</dd>
						<dd><a target="_blank">配送方式</a>|</dd>
						<dd><a target="_blank">售后服务</a>|</dd>
						<dd><a target="_blank">购物帮助</a>|</dd>
						<dd><a target="_blank">蔬菜卡</a>|</dd>
						<dd><a target="_blank">礼品卡</a>|</dd>
						<dd><a target="_blank">银联卡</a>|</dd>
						<dd><a target="_blank">亿家卡</a>|</dd>
						<dd class="more"><a >更多</a></dd>
					</dl>
				</div>
			</div>
		</div>
		
		<%@ include file="bottom.jsp" %>

	</body>
</html>