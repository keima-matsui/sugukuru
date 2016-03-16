<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="cont_login">
	<!-- cntHeader -->
	<div class="cntCenter login">
		<p class="backShop">
			<a href="/Sugukuru/">ショップへ戻る</a>
		</p>
		<div class="middle">
			<h3 class="topTitle">
				<span>Sugukuruへようこそ！（個人）</span>
			</h3>
			<p class="info">個人－ログイン</p>
			<ul class="attention">
				<li>IDとパスワードを入力してください。</li>
				<li class="forgotPass"><a href="/Sugukuru/Regist">パスワードを忘れた方はこちらから再登録をお願いします</a></li>
				<li class="forgotPass"><a href="/Sugukuru/CompanyLogin">企業の方はこちらから</a></li>
			</ul>
			<div class="loginBox">
				<form action="Login" method="post">
					<dl>
						<dt>
							<label for=id>ID</label>
						</dt>
						<dd>
							<input type="text" name="id" id="id">
						</dd>
						<dt class="last">
							<label for="password">パスワード</label>
						</dt>
						<dd class="last">
							<input type="text" name="password" id="password">
						</dd>
					</dl>
					<button type="submit"></button>
				</form>
			</div>
		</div>
	</div>
	<!-- cntCenter -->
</div>




