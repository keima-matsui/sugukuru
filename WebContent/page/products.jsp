<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.Product,org.apache.commons.lang3.StringUtils" %>
<%
List<Product> products = (List<Product>)request.getAttribute("products");
String title = (String)request.getAttribute("title");
%>


<ul class="breadCrumbs   help_bread">
	<li><a href="/Sugukuru/" title="ホーム">ホーム</a></li>
	<li class="arrow">&gt;</li>
	<li><%=title %></li>
</ul>
<% if(products.size() != 0){ %>
<div class="cont_product">
	<div class="actions  ">
		<ul class="sort">
			<li>おすすめ順</li>
			<li><a href="#">価格順</a></li>
			<li><a href="#">新着順</a></li>
		</ul>
		<ul class="pagination">
			<li class="leftArrow"><a href="#">&nbsp;</a></li>
			<li class="current"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li class="rightArrow"><a href="#">&nbsp;</a></li>
		</ul>
	</div>
	<p class="p_text">全 [<%=products.size() %>] 商品中 [1-<%=products.size() %>] 商品を表示しています</p>
	<div class="contProducts">
		<ul>

			<% for(Product p : products){ %>
			<li class="item"><a href="/Sugukuru/ProductDetail?id=<%= p.getId() %>"><img
					src="/Sugukuru/productImage/main/<%= p.getId() %>.jpg" alt="" width="83px" height="129px" /></a>
				<div class="desc">
					<p class="title">
						<a href="/Sugukuru/ProductDetail?id=<%= p.getId() %>"><%= p.getName() %></a>
					</p>
					<span class="info"><%= StringUtils.abbreviate(p.getDetail(), 60) %></span>
				</div>
				<p class="price"><%= String.format("%1$,3d", p.getPrice()) %>円<span>（税込）</span>
				</p>
				<div class="toItem">
					<a href="/Sugukuru/ProductDetail?id=<%=p.getId()%>">詳細を見る</a>
				</div>
			</li>
			<% } %>
		</ul>

	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.contProducts a').hover(function() {
				$(this).find('i').addClass('border_image');
			}, function() {
				$('.contProducts i').removeClass('border_image');
			});
		});
	</script>
	<div class="actions  ">
		<ul class="sort">
			<li>おすすめ順</li>
			<li><a href="#">価格順</a></li>
			<li><a href="#">新着順</a></li>
		</ul>
		<ul class="pagination">
			<li class="leftArrow"><a href="#">&nbsp;</a></li>
			<li class="current"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li class="rightArrow"><a href="#">&nbsp;</a></li>
		</ul>
	</div>
	<p class="p_text">全 [<%=products.size() %>] 商品中 [1-<%=products.size() %>] 商品を表示しています</p>
</div>
<% } else { %>
	<div>
		<br />
		<h1>該当商品がありません</h1>
	</div>
<% } %>
