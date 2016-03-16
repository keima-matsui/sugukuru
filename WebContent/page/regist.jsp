<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    	#registButton{
    		margin: 20px;
    	}
    	#registButton input{
    		width:200px;
    	}
    </style>
<div class="cont_login">
	<!-- cntHeader -->
	<div class="cntCenter login">
		<p class="backShop">
			<a href="/Sugukuru/">ショップへ戻る</a>
		</p>
		<div class="middle">
			<h3 class="topTitle">
				<span>Sugukuru個人登録ページ！</span>
			</h3>
			<p class="info">個人－新規登録</p>
			<ul class="attention">
				<li>メールアドレスとパスワードを入力してください。</li>
				<li class="forgotPass">メールがとどかない場合はお問い合わせ後再登録をお願いします</li>
				<li class="forgotPass"><a href="/Sugukuru/CompanyRegist">企業の方はこちらから登録</a></li>
			</ul>
			<div class="loginBox">
				<form action="Regist" method="post">
					<dl>
						<dt>
							<label for=id>メールアドレス</label>
						</dt>
						<dd>
							<input type="email" name="email" id="id" required>
						</dd>
						<dt class="last">
							<label for="password">パスワード</label>
						</dt>
						<dd class="last">
							<input type="text" name="password" id="password" required>
						</dd>
					</dl>
					<div align="center" id="registButton">
						<input type="submit" value="登録する">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- cntCenter -->
</div>