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
    <li><a href="/Sugukuru/" title="ホーム">ホーム</a></li>
    <li class="arrow">&gt;</li>
    <li><a href="/Sugukuru/Cart" title="カート">ショッピングカート</a></li>
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
	<table border="1" cellspacing="0" id="customerAddressFrom">
		<tr>
			<th width="30%">名前</th>
			<td>【姓】<input type="text" name="last_name" required>【名】<input type="text" name="first_name" required></td>
		</tr>
		<tr>
			<th>郵便番号</th>
			<td>※ハイフン不要<input type="text" name="post_address" required></td>
		</tr>
		<tr>
			<th>区</th>
			<td>
				<select name="ward">
					<option value="1">千代田区</option>
					<option value="2">中央区</option>
					<option value="3">港区</option>
					<option value="4">新宿区</option>
					<option value="5">文京区</option>
					<option value="6">台東区</option>
					<option value="7">墨田区</option>
					<option value="8">江東区</option>
					<option value="9">品川区</option>
					<option value="10">目黒区</option>
					<option value="11">大田区</option>
					<option value="12">世田谷区</option>
					<option value="13">渋谷区</option>
					<option value="14">中野区</option>
					<option value="15">杉並区</option>
					<option value="16">豊島区</option>
					<option value="17">北区</option>
					<option value="18">荒川区</option>
					<option value="19">板橋区</option>
					<option value="20">練馬区</option>
					<option value="21">足立区</option>
					<option value="22">葛飾区</option>
					<option value="23">江戸川区</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>住所</th>
			<td><input type="text" name="address" required></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td>※ハイフン不要<input type="text" name="phone" required></td>
		</tr>
		<tr>
			<th>メールアドレス</th>
			<td>
				<input type="text" name="email" required><br />
				確認のためもう一度入力してください。<br />
				<input type="text" name="email2" required>
			</td>
		</tr>
		<tr>
			<th>クレジットカード情報</th>
			<td id="creditCard">
				<div class="demo-container">
			        <div class="card-wrapper"></div>
			        <div class="fosrm-container active">
						<input placeholder="Card number" type="text" name="number" required>
						<input placeholder="Full name" type="text" name="name" required>
				     	<input placeholder="MM/YY" type="text" name="expiry" required>
				    	<input placeholder="CVC" type="text" name="cvc" required>
			        </div>
			    </div>
			</td>
		</tr>
	</table>

	<div align="center">
			<button type="submit" id="paymentButton">購入する</button>
	</div>
</form>

<script src="/Sugukuru/material/js/jquery.card.js"></script>
<script src="/Sugukuru/material/js/card.js"></script>
<script>
        new Card({
            form: document.querySelector('form'),
            container: '.card-wrapper'
        });
</script>