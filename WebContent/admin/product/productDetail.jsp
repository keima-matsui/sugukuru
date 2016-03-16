<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sugukuru.bean.Product" %>
<%
	Product p = (Product)request.getAttribute("product");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../material/tpl/default/meta.jsp"%>
</head>
<body>
<div id="header">
		<%@ include file="../material/tpl/default/header.jsp"%>
	</div>

	<div id="main">
		<div id="content">
			<div id="contentIn">
				<h2>商品詳細</h2>
				<div id="contents">
					<img alt="<%= p.getName() %>" src="/Sugukuru/productImage/main/<%= p.getId() %>.jpg" width="300px" height="300px">
					<p>商品名:<%= p.getName() %></p>
					<p>価格:<%= p.getPrice() %></p>
				</div>
			</div>
		</div>

		<div id="side">
			<%@ include file="../material/tpl/default/side.jsp"%>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>