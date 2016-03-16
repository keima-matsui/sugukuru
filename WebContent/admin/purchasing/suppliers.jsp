<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Supplier"%>
<%
	List<Supplier> suppliers = (List<Supplier>)request.getAttribute("suppliers");
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
				<h2>サプライヤー管理</h2>
				<div id="contents">
					<a href="/Sugukuru/Admin/Purchasing/AddSuppliers">サプライヤー追加</a>
					<table class="customeTable">
						<thead>
							<tr>
								<td>ID</td>
								<td>サプライヤー名</td>
								<td>登録日</td>
								<td>詳細</td>
								<td>更新</td>
								<td>削除</td>
							</tr>
						</thead>
						<tbody class="list">
							<% for(Supplier s : suppliers){ %>
							<tr>
								<td><%= s.getId() %></td>
								<td><%= s.getSupplierName() %></td>
								<td><%= s.getDate() %></td>
								<td><button>詳細</button></td>
								<td><button>更新</button></td>
								<td><button>削除</button></td>
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