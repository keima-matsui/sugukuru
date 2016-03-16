<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Product,org.apache.commons.lang3.StringUtils" %>
<%
List<Product> reccomend = (List<Product>)request.getAttribute("reccomend");
List<Product> newProducts = (List<Product>)request.getAttribute("newProducts");
%>
<style type="text/css">
#foo2 {
	width: 519px;
}

#foo2 li {
	float: left;
}

#foo2 li img {
	width: 100%;
}
#foo0 {
	margin: 25px 0 0 30px;
}

#foo0>div {
	float: left;
}
</style>

<div class="slideMenu">
	<div id="thumb">
		<div id="pager2"></div>
	</div>
	<div style="padding: 3px 0 80px 0;" id="leftsideGallery">
		<div class="gallery_desk"
			style="overflow: hidden; text-align: center;">
			<div id="carousel"
				style="margin: auto; height: 420px; margin-top: 3px;">
				<ul id="foo2">
					<li><img src="/Sugukuru/images/slider/mainImg04.jpg" width="519"
						height="428" alt="" /> <a class="shop_now" href="#">詳細はこちら</a></li>
					<li><img src="/Sugukuru/images/slider/mainImg05.jpg" width="519"
						height="428" alt="" /> <a class="shop_now" href="#">詳細はこちら</a></li>
					<li><img src="/Sugukuru/images/slider/mainImg06.jpg" width="519"
						height="428" alt="" /> <a class="shop_now" href="#">詳細はこちら</a></li>
					<li><img src="/Sugukuru/images/slider/mainImg07.jpg" width="519"
						height="428" alt="" /> <a class="shop_now" href="#">詳細はこちら</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<!-- 以下新着商品 -->
<h3>新着商品</h3>
<div class="newProducts">
	<div id="foo0" class="contCarousel">
		<% for(Product p : newProducts){ %>
		<div>
			<a class="box clearfix" href="/Sugukuru/ProductDetail?id=<%=p.getId()%>"> <img src="/Sugukuru/productImage/main/<%= p.getId() %>.jpg" alt="" width="50px" height="80px" />
			<span class="cont">
					<span class="info"><%= p.getName() %></span> <strong><%= String.format("%1$,3d", p.getPrice()) %>円(税込)</strong>
			</span>
			</a>
		</div>
		<% } %>
	</div>
</div>
<!-- 新着商品ここまで -->

<!-- 以下おすすめ商品 -->
<h3>おすすめ商品</h3>
<ul class="products">
	<% for(Product p : reccomend){ %>
	<li class="border_bottom">
		<img src="/Sugukuru/productImage/main/<%= p.getId() %>.jpg"alt="image" />
		<p>
			<a href="/Sugukuru/ProductDetail?id=<%=p.getId()%>"><%= StringUtils.abbreviate(p.getName(), 18) %></a>
		</p><span><b><%= String.format("%1$,3d", p.getPrice()) %>円</b>(税込)</span>
	</li>
	<% } %>
</ul>
<!-- おすすめ商品ここまで -->


<h3>売れ筋商品</h3>
<ul class="products">
	<% for(Product p2 : reccomend){ %>
	<li class="border_bottom">
		<img src="/Sugukuru/productImage/main/<%= p2.getId() %>.jpg"alt="image" />
		<p>
			<a href="/Sugukuru/ProductDetail?id=<%=p2.getId()%>"><%= StringUtils.abbreviate(p2.getName(), 18) %></a>
		</p><span><b><%= String.format("%1$,3d", p2.getPrice()) %>円</b>(税込)</span>
	</li>
	<% } %>
</ul>

<h3>お知らせ</h3>
<div class="contInfo">
	<dl>
		<dt class="first">
			<span>2014年08月01日</span>
		</dt>
		<dd class="first">
			<a href="#">ダミーテキストダミーテキスト</a>
		</dd>
		<dt>
			<span>2014年07月01日</span>
		</dt>
		<dd>
			<a href="#">ダミーテキストダミーテキスト</a>
		</dd>
		<dt>
			<span>2014年06月01日</span>
		</dt>
		<dd>
			<a href="#">ダミーテキストダミーテキスト</a>
		</dd>
		<dt>
			<span>2014年05月01日</span>
		</dt>
		<dd>
			<a href="#">ダミーテキストダミーテキスト</a>
		</dd>
		<dt>
			<span>2014年04月04日</span>
		</dt>
		<dd>
			<a href="#">ダミーテキストダミーテキスト</a>
		</dd>
	</dl>
</div>
<p style="height: 90px;"></p>