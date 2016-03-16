<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="headerInner">
	<h1>
		<a href="/Sugukuru/Admin"><img src="/Sugukuru/admin/material/tpl/default/img/common/logo.png" alt="sugukuru" /></a>
	</h1>
		<% if(session.getAttribute("employee") != null){ %>
			<p class="r">[ <a href="/Sugukuru/Logout">ログアウト</a> ]</p>
		<% } %>
	<div class="clear"></div>
</div>
