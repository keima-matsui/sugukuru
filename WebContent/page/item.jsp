<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sugukuru.bean.Product"%>
<%
	Product p = (Product) request.getAttribute("product");
%>
<% if(p != null){ %>
<ul class="breadCrumbs   help_bread">
	<li><a href="./" title="ホーム">ホーム</a></li>
	<li class="arrow">&gt;</li>
	<li><%= p.getName() %></li>
</ul>
<section>
	<div class="itemArea clearfix">
		<div class="itemImgArea clearfix">
			<div class="imgBox">
				<ul id="foo3">
					<li><img src="productImage/main/<%= p.getId()%>.jpg" alt="" width="500" height="500" /></li>
				</ul>
			</div>
			<div id="foo3_pag"></div>
		</div>
		<!--itemImgArea end-->
		<div class="itemDateArea">
			<h1><%= p.getName()%></h1>
			<p class="itemPrice">
				販売価格：<%= String.format("%1$,3d", p.getPrice())%>円<span>(税込)</span>
			</p>
			<form action="Cart" method="post">
				<p class="itemNum">
					数量：<select name="quantity">
						<option value='1'>1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</p>
				<input type="hidden" value="<%= p.getId() %>" name="product_id">
				<div class="addBtn">
					<input type="submit" class="overimg" value="カートに入れる" />
				</div>
			</form>
		</div>
		<!--itemDateArea end-->

	</div>
	<!--itemArea end-->
	<div class="subContentArea">
		<h2>商品説明</h2>
		<p>
			<%= p.getDetail()%>
		</p>
	</div>
</section>
<% }else{ %>
	<ul class="breadCrumbs   help_bread">
		<li><a href="./" title="ホーム">ホーム</a></li>
		<li class="arrow">&gt;</li>
		<li>商品ページ</li>
	</ul>
	<h3>お探しの商品はありません。</h3>
<% } %>