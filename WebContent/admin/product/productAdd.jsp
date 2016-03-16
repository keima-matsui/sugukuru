<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Category"%>
<%
	List<Category> categorys = (List<Category>)request.getAttribute("categorys");
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
				<h2>商品追加画面</h2>
				<div id="contents">
					<form action="ProductAdd" method="post" enctype="multipart/form-data">

						<label>商品名</label><input type="text" name="name"><br><br>

						<label>カテゴリ</label>
						<select name="category">
							<% for(Category c : categorys){ %>
								<option value="<%= c.getId() %>"><%= c.getName() %></option>
							<% } %>
						</select>
						<br><br>

						<label>説明文</label><textarea name="detail"></textarea>
												<br><br>

						<label>価格</label><input type="number" name="price">
						<br><br>

						<label>画像</label>
						<input type="file" name="image">
						<br><br>

						<input type="submit" value="送信">

					</form>
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