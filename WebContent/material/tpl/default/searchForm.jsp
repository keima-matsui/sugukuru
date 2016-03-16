<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String word = (String)request.getAttribute("word");
	if (word == null){
		word = "";
	}
%>
<form action="/Sugukuru/Products" method="GET">
	<p class="search">
		<input class="text" name="word" type="text" value="<%= word %>"/>
		<input type="hidden" name="mode" value="search">
	    <input class="button" name="" value="" type="submit" />
	</p>
</form>