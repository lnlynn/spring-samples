<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>传智网上商城</title>
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<%@ include file="head.jsp" %>
		
		<div class="container productList">
			<div class="span6">
				<div class="hotProductCategory">
					<c:forEach items="${categoryList }" var="categoryList">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm">${categoryList.cname }</a>
							</dt>
							<c:forEach items="${categoryList.categorySeconds }" var="categorySeconds">
								<dd><a>${categorySeconds.csname }</a></dd>
							</c:forEach>
						</dl>
					</c:forEach>
				</div>
			</div>
			
			<div class="span18 last">
				<form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">
					<input type="hidden" id="brandId" name="brandId" value=""/>
					<input type="hidden" id="promotionId" name="promotionId" value=""/>
					<input type="hidden" id="orderType" name="orderType" value=""/>
					<input type="hidden" id="pageNumber" name="pageNumber" value="1"/>
					<input type="hidden" id="pageSize" name="pageSize" value="20"/>
						
					<div id="result" class="result table clearfix">
						<ul>
						<c:forEach items="${category.categorySeconds }" var="categorySeconds">
							<c:forEach items="${categorySeconds.products }" var="product">
							<li>
								<a href="${pageContext.request.contextPath}/productDetail.action?pid=${product.pid}" target="_self">
									<img src="${pageContext.request.contextPath}/${product.image}" width="170" height="170"  style="display: inline-block;"/>			   
									<span style='color:green'>
										${product.pname}
									</span>
									<span class="price">
										商城价： ￥${product.shop_price}/份
									</span>			 
								</a>
							</li>
							</c:forEach>
						</c:forEach>
						</ul>
					</div>
					<div class="pagination">
						<span class="firstPage">&nbsp;</span>
						<span class="previousPage">&nbsp;</span>
						<span class="currentPage">1</span>
						<a href="javascript: $.pageSkip(2);">2</a>
						<a class="nextPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
						<a class="lastPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
					</div>
				</form>
			</div>
		</div>
	
		<%@ include file="bottom.jsp" %>
	</body>
</html>