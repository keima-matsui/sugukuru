<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("userId") == null){ %>
	<div id="top" style="width:960px; height:100px; margin:0 auto; position:relative; font-size:11px;">
		<h1 style="color:#FFF; width:45%; float:left; margin: 10px 0 0; font-weight:normal;">
	    	ほしい物がすぐ来る手に入る
	    </h1>
	    <ul id="link" style="float:right; width:45%; text-align:right; margin: 10px 0 0;">
	    	<li><a href="/Sugukuru/Regist"><s>►</s>新規会員登録</a></li>
	        <li><a href="/Sugukuru/site_map.jsp"><s>►</s>サイトマップ</a></li>
		</ul>
	    <p style="font-size:50px; position:absolute; left: 0; top:35px; ">
	    	<a href="/Sugukuru/">SUGU<font style="color:#fc63a3;">KURU</font><br />
	        <span style="font-size:12px; float:left;">Hoshii Mono Ga Sugu Tenihairu</span></a>
	    </p>
	    <nav class="menu">
	        <ul style="position:absolute; top:40px; right:0; width:620px;">
	            <li><a href="/Sugukuru/">TOP</a></li>
	            <li><a href="/Sugukuru/Products?mode=new">新商品</a></li>
	            <li><a href="/Sugukuru/payment.jsp">お支払方法</a></li>
	            <li><a href="/Sugukuru/contact.jsp">お問合せ</a></li>
	            <li><a href="/Sugukuru/Login">ログイン</a></li>
	        </ul>
		</nav>
	</div>
<% }else{ %>
	<div id="top" style="width:960px; height:100px; margin:0 auto; position:relative; font-size:11px;">
		<h1 style="color:#FFF; width:45%; float:left; margin: 10px 0 0; font-weight:normal;">
	    	ほしい物がすぐ来る手に入る
	    </h1>
	    <ul id="link" style="float:right; width:45%; text-align:right; margin: 10px 0 0;">
	    	<li><a href="/Sugukuru/MyPage"><s>►</s>マイページ</a></li>
	        <li><a href="/Sugukuru/site_map.jsp"><s>►</s>サイトマップ</a></li>
		</ul>
	    <p style="font-size:50px; position:absolute; left: 0; top:35px; ">
	    	<a href="/Sugukuru/">SUGU<font style="color:#fc63a3;">KURU</font><br />
	        <span style="font-size:12px; float:left;">Hoshii Mono Ga Sugu Tenihairu</span></a>
	    </p>
	    <nav class="menu">
	        <ul style="position:absolute; top:40px; right:0; width:620px;">
	            <li><a href="/Sugukuru/">TOP</a></li>
	            <li><a href="/Sugukuru/Products?mode=new">新商品</a></li>
	            <li><a href="/Sugukuru/payment.jsp">お支払方法</a></li>
	            <li><a href="/Sugukuru/contact.jsp">お問合せ</a></li>
	            <li><a href="/Sugukuru/Logout">ログアウト</a></li>
	        </ul>
		</nav>
	</div>
<% } %>