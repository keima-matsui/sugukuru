<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.CartProduct" %>
<%
	List<CartProduct> products = (List<CartProduct>)request.getAttribute("products");
	int sum = 0;
%>
<style>
	#cart {
		width: 100%;
	}
	#cart tr{
		border-bottom:solid 1px #ccc;
	}
	#cart tr td{
		padding: 10px;
		vertical-align: top;
	}
	#cart tr td a{
		color:#0066c0;
	}
	#total{
		margin: 10px;
		font-size: 20px;
		text-align: right;
	}
	#total #totalPrice{
		color: #f00;
	}
	#order{
		padding: 10px;
		color: #fff;
		cursor: pointer;
		background-color: #f00;
		border-radius:5px;
		border: 0;
	}
</style>

<ul class="breadCrumbs clearfix help_bread">
    <li><a href="./" title="ホーム">ホーム</a></li>
    <li class="arrow">&gt;</li>
    <li>ショッピングカート</li>
</ul>
<h3>ショッピングカート</h3>
<% if(products.size() != 0){ %>
<div id="cart">
	<table id="cart">
		<thead>
			<tr>
				<td></td>
				<td></td>
				<td>価格</td>
				<td>数量</td>
			</tr>
		</thead>
		<tbody>
			<% for(CartProduct p : products){ %>
				<tr>
					<td><img src="productImage/main/<%= p.getId() %>.jpg" width="83px" height="100px"></td>
					<td><a href="ProductDetail?id=<%= p.getId() %>"><%= p.getName() %></a></td>
					<td class="price"><%= String.format("%1$,3d", p.getPrice()) %>円</td>
					<td><%= p.getQuantity() %></td>
				</tr>
				<% sum += (p.getPrice() * p.getQuantity()); %>
			<% } %>
		</tbody>
	</table>
	<p id="total">小計(<%= products.size() %>商品)：<span id="totalPrice"><%= String.format("%1$,3d", sum) %>円</span></p>
	<div align="right"><button id="order" onClick="location.href='Order'">この内容で注文</button></div>
</div>
<% }else{ %>
	<h1>現在カートには商品が入っていません。</h1>
<% } %>