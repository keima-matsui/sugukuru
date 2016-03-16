<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Category,sugukuru.dao.ProductCategoryDao" %>
<%
	ProductCategoryDao pcDao = new ProductCategoryDao();
	List<Category> categorys = pcDao.getAllvategory();
%>
    <style>
    	.scroll-pane{
    		height: 260px;
    	}
    </style>
<a href="/Sugukuru/about_us.jsp" class="about">当店について</a>
<nav class="leftmenu">
	<h2>カテゴリから探す</h2>
    <ul>
    	<% for(Category c : categorys){ %>
        	<li><a href="/Sugukuru/Products?mode=category&id=<%= c.getId() %>"><s>●</s><%= c.getName() %></a></li>
        <% } %>
    </ul>
    <h2>条件で探す</h2>
    <ul>
        <li><a href="Products?mode=new"><s>●</s>新商品</a></li>
        <li><a href="Products?mode=popular"><s>●</s>人気商品</a></li>
        <li><a href="Products?mode=selling"><s>●</s>売れ筋商品</a></li>
        <li><a href="Products?mode=recommend"><s>●</s>おすすめ商品</a></li>
        <li><a href="Products"><s>●</s>全商品</a></li>
    </ul>
</nav>
    <h2>Twitter</h2>
    <div class="cntTwitter">
	    <div id="tweet">
		    <div class="scroll-pane">
				<div class="tweet">

<a class="twitter-timeline" href="https://twitter.com/askul_com" data-widget-id="646159443852324864">@askul_comさんのツイート</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>


				<!--ここまで-->


				</div>
			</div>
		</div>
	 </div>
	<h2>Facebook</h2>
    <div class="contFacebook">

		<iframe src="//www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Faskulshop&amp;width=190&amp;height=380&amp;colorscheme=light&amp;show_faces=true&amp;header=false&amp;stream=false&amp;show_border=true&amp;appId=333595940121110" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:190px; height:380px;" allowTransparency="true"></iframe>



	</div>
