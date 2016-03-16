<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Payment" %>
<%
	int year = (Integer) request.getAttribute("year");
	int month = (Integer) request.getAttribute("month");
	List<Payment> payments = (List<Payment>)request.getAttribute("payments");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../material/tpl/default/meta.jsp"%>
<script>
$(function() {
    $('.list tr').pagination({
        pager        : $('.pager'),
        prevText     : '＜',
        nextText     : '＞',
        firstText    : '≪',
        lastText     : '≫',
        viewNum      : 10,
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
				<h2>顧客入金確認</h2>
				<div id="contents">
					<form action="?" method="get">
						<select name="year">
							<%for(int y = 2000; y < year; y++){ %>
								<option value="<%= y %>"><%= y %></option>
							<% } %>
							<option value="<%= year %>" selected><%= year %></option>
						</select>

						<select name="month">
							<%for(int m = 1; m <= 12; m++){ %>
								<% if(m == month){ %>
									<option value="<%= m %>" selected><%= m %></option>
								<% }else{ %>
									<option value="<%= m %>"><%= m %></option>
								<% } %>
							<% } %>
						</select>
						<button action="submit">表示</button>
					</form>
					<% if(payments.isEmpty()){ %>
						<h1>該当データはありません</h1>
					<% }else{ %>
						<table class="customeTable">
							<thead>
								<tr>
									<td>伝票番号</td>
									<td>顧客番号</td>
									<td>顧客名</td>
									<td>受注日</td>
									<td>合計金額</td>
									<td>詳細</td>
								</tr>
							</thead>
							<tbody class="list">
								<% for(Payment p : payments){ %>
									<tr>
										<td><%= p.getOrderId() %></td>
										<td><%= p.getId() %></td>
										<td><%= p.getName() %></td>
										<td><%= p.getOrderDate() %></td>
										<td><%= p.getTotalAmount() %></td>
										<td><button>詳細</button></td>
									</tr>
								<% } %>
							</tbody>
						</table>
						<div class="pager"></div>
					<% } %>
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