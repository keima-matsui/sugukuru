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
				<h2>サプライヤー追加</h2>
				<div id="contents">
					<form action="?" method="POST">
						<p>サプライヤー名:<input type="text" name="supplierName" required></p>
						<p>代表者名:<input type="text" name="readerName" required></p>
						<p>郵便番号:<input type="text" name="postAddress" required></p>
						<p>住所:<input type="text" name="address" required></p>
						<p>電話番号:<input type="text" name="phoneNumber" required></p>
						<p>メモ：<textarea name="memo"></textarea></p>
						<button type="submit">追加</button>
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