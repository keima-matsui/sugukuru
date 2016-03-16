<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="sugukuru.dao.ProductsDao,sugukuru.bean.Product,java.util.List"%>
<%
	ProductsDao pDao = new ProductsDao();
	List<Product> rankingProducts = pDao.getRankingProducts();
%>
<div class="cntTopBtns">
	<a href="Cart" class="btn1">カートの中を確認する</a> <a href="beginners.jsp"
		class="btn2">初めての方へ</a>
</div>
<ul class="rightMenu clearfix">
	<li class="ir-1"><a href="/Sugukuru/guide.jsp"><span>ご利用ガイド</span></a></li>
	<li class="ir-2"><a href="/Sugukuru/payment.jsp"><span>お支払方法</span></a></li>
	<li class="ir-3"><a href="/Sugukuru/delivery.jsp"><span>配送方法・送料について</span></a>
	</li>
	<li class="ir-4"><a href="/Sugukuru/qa.jsp"><span>よくあるご質問</span></a></li>
	<li class="ir-6"><a href="/Sugukuru/tokusho.jsp"><span>特定商取引法について</span></a>
	</li>
	<li class="ir-7"><a href="/Sugukuru/about_us.jsp"><span>このサイトについて</span></a>
	</li>
	<li class="ir-8"><a href="/Sugukuru/site_map.jsp"><span>サイトマップ</span></a></li>
	<li class="ir-9"><a href="/Sugukuru/contact.jsp"><span>お問合わせ</span></a></li>
</ul>
<h2>お支払い方法</h2>
<div class="cont_menu">
	<ul>
		<li>銀行振込</li>
		<li>クレジットカード</li>
	</ul>
	<img src="/Sugukuru/images/rightside/payment_methods.jpg" alt="" />
</div>
<h2>Top Ranking</h2>
<div class="topRanking">
	<div class="cont">
		<% int i = 1; %>
		<% for(Product p2 : rankingProducts){ %>
			<div class="item clearfix">
				<em class="number i<%= i %>">&nbsp;</em><i><img
					src="/Sugukuru/productImage/main/<%= p2.getId() %>.jpg" alt="" width="85" height="132" /></i>
				<div class="info">
					<p><%= p2.getName() %></p>
					<a href="/Sugukuru/ProductDetail?id=<%=p2.getId()%>">詳細を見る</a>
				</div>
			</div>
			<% i++; %>
		<% } %>
	</div>
</div>