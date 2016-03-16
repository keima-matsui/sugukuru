<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, sugukuru.bean.Product"%>
<%
	List<Product> products = (List<Product>)request.getAttribute("products");
	String msg = "";
	msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../../material/tpl/default/meta.jsp"%>
</head>
<body>
<div id="header">
		<%@ include file="../../material/tpl/default/header.jsp"%>
	</div>

	<div id="main">
		<div id="content">
			<div id="contentIn">
				<h1>在庫管理TOP</h1>
				<form method="post" action ="sugukuru.controller.admin.Admin" >
		<% if(msg != null){ %>
		<div class="alert alert-danger" role="alert"><%=msg %></div>
		<% } %>
		<table>
			<tr>
				<th>商品ID</th>
				<th>カテゴリID</th>
				<th>商品名</th>
				<th>価格</th>
				<th>在庫数</th>
			<tr>
			<% for (Product p : products) { %>
				<tr>
					<td><%=p.getId() %></td>
					<td><%=p.getCategoryId()%></td>
					<td><%=p.getName()%></td>
					<td><%=p.getPrice()%></td>
					<td><input type="text" name="stock" value="<%= p.getStock() %>"size="10"/></td>
				</tr>
				<input type="hidden" name="productId" value="<%= p.getCategoryId() %>">
			<% } %>
		</table>
		<p><input type="submit" value="修正する"></p>
	</form>
			</div>
		</div>

		<div id="side">
			<%@ include file="../../material/tpl/default/side.jsp"%>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>