<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Order"%>
<%
	List<Order> orders = (List<Order>)request.getAttribute("orders");
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
        viewNum      : 8,
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
				<h2>受注一覧</h2>
				<div id="contents">
					<table class="customeTable">
						<thead>
							<tr>
								<td>ID</td>
								<td>注文者</td>
								<td>注文日</td>
								<td>合計金額</td>
								<td>状態</td>
								<td>確認</td>
							</tr>
						</thead>
						<tbody class="list">
							<% for(Order o : orders){ %>
								<tr>
									<td><%= o.getId() %></td>
									<td><%= o.getOrderdName() %></td>
									<td><%= o.getDate() %></td>
									<td><%= o.getTotalAmount() %></td>
									<td><%= o.getStatus() %></td>
									<td><a href="/Sugukuru/Admin/Sale/OrderDetail?id=<%= o.getId() %>">確認</a></td>
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