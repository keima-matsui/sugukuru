<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Product"%>
<%
	List<Product> products = (List<Product>)request.getAttribute("products");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../material/tpl/default/meta.jsp"%>
<style>
.thumbnail{
	border:solid 1px #000;
}
</style>
<script>
$(function() {
    $('.list tr').pagination({
        pager        : $('.pager'),
        prevText     : '＜',
        nextText     : '＞',
        firstText    : '≪',
        lastText     : '≫',
        viewNum      : 5,
        pagerNum     : 3,
        ellipsis     : false,
        linkInvalid  : true,
        goTop        : true,
        firstLastNav : true,
        prevNextNav  : false
    });
});
</script>
</head>
<body>
<div id="header">
		<%@ include file="../material/tpl/default/header.jsp"%>
	</div>

	<div id="main">
		<div id="content">
			<div id="contentIn">
				<h2>商品管理</h2>
				<div id="contents">
					<a href="/Sugukuru/Admin/ProductManagement/ProductAdd">商品追加</a>
					<table class="customeTable">
						<thead>
							<tr>
								<td>サムネイル</td>
								<td>ID</td>
								<td>商品名</td>
								<td>価格</td>
								<td>詳細</td>
								<td>確認</td>
							</tr>
						</thead>
						<tbody class="list">
							<% for(Product p : products){ %>
								<tr>
									<td><img src="/Sugukuru/productImage/main/<%= p.getId() %>.jpg" height="60px" width="60px" class="thumbnail"></td>
									<td><%= p.getId() %></td>
									<td><%= p.getName() %></td>
									<td><%= p.getPrice() %></td>
									<td><a href="/Sugukuru/Admin/ProductManagement/ProductDetailAdmin?id=<%= p.getId() %>">詳細</a></td>
									<td><a href="/Sugukuru/ProductDetail?id=<%= p.getId() %>">確認</a></td>
								</tr>
							<%} %>
						</tbody>
					</table>
					<div class="pager"></div>
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