<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="material/tpl/default/meta.jsp" %>
</head>
<body>
<div id="container">
  <header id="header">
    <%@ include file="material/tpl/default/header.jsp" %>
  </header>
  <div class="content">
    <aside id="leftside">
      <%@ include file="material/tpl/default/leftside.jsp" %>
    </aside>

    <article id="center">
		<ul class="breadCrumbs clearfix help_bread">
		    <li><a href="/Sugukuru/" title="ホーム">ホーム</a></li>
		    <li class="arrow">&gt;</li>
		    <li>エラーです</li>
		</ul>
		<h3>予期せぬ問題が発生しました。管理者にお問い合わせください</h3>
    </article>

    <aside id="rightside">
      <%@ include file="material/tpl/default/rightside.jsp" %>
    </aside>
    <div class="empty"> &nbsp; </div>
  </div>
</div>
<footer id="footer">
  <div class="content">
    <%@ include file="material/tpl/default/footer.jsp" %>
  </div>
</footer>
</body>
</html>