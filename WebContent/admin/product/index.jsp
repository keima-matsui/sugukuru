<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<h2>商品管理部TOP</h2>
				<div id="contents">
					<a href="#">在庫管理</a>
					<a href="/Sugukuru/Admin/ProductManagement/ProductList">商品管理</a>
					<a href="#">仕入管理</a>
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