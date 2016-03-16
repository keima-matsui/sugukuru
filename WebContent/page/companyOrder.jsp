<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,sugukuru.bean.CartProduct" %>
<%
	List<CartProduct> products = (List<CartProduct>)request.getAttribute("products");
	int sum = 0;
%>

<style>
	#orderTable{
		margin:50px 0;
		width: 100%;
	}
	#orderTable thead{
		text-align: center;
	}
	#orderTable thead tr td{
		height: 50px;
		line-height: 50px;
		background-color: #eee;
	}
	#orderTable tbody tr td{
		padding: 10px;
	}
	.orderTableRight{
		text-align: right;
	}
	#customerAddressFrom{
		width: 100%;
	}
	#customerAddressFrom tr th{
		padding: 15px;
	}
	#customerAddressFrom tr td{
		text-align: center;
		padding: 10px;
	}
	#creditCard{
		padding: 10px;
		border: 0;
	}
	#creditCard input{
		margin: 10px auto;
		display: block;
	}
</style>
<ul class="breadCrumbs clearfix help_bread">
    <li><a href="./" title="ホーム">ホーム</a></li>
    <li class="arrow">&gt;</li>
    <li><a href="Cart" title="カート">ショッピングカート</a></li>
    <li class="arrow">&gt;</li>
    <li>注文内容の確認</li>
</ul>
<h3>注文内容の確認</h3>

<table border="1" cellspacing="0" id="orderTable">
	<thead>
		<tr>
			<td width="50%">商品名</td>
			<td width="15%">単価（税込み）</td>
			<td width="15%">注文数</td>
			<td width="20%">小計</td>
		</tr>
	</thead>
	<tbody>
		<% for(CartProduct p : products){ %>
			<tr>
				<td><%= p.getName() %></td>
				<td class="orderTableRight"><%= String.format("%1$,3d", p.getPrice()) %></td>
				<td class="orderTableRight"><%= p.getQuantity() %></td>
				<td class="orderTableRight"><%= String.format("%1$,3d", p.getPrice() * p.getQuantity()) %></td>
			</tr>
			<% sum += (p.getPrice() * p.getQuantity()); %>
		<% } %>
		<tr>
			<td colspan="3" class="orderTableRight">合計</td>
			<td class="orderTableRight"><%= String.format("%1$,3d", sum) %></td>
		</tr>
	</tbody>
</table>

<form action="Payment" method="post">
	<div align="center">
		<button type="submit" id="paymentButton">購入する</button>
		<button type="submit" id="paymentButton">見積もり依頼</button>
	</div>
</form>

<script src="./material/js/jquery.card.js"></script>
<script src="./material/js/card.js"></script>
<script>
        new Card({
            form: document.querySelector('form'),
            container: '.card-wrapper'
        });
</script>