<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="cont_contact">
	<!-- cntHeader -->
	<div class="cntCenter contact">
		<p class="backShop">
			<a href="./">ショップへ戻る</a>
		</p>
		<div class="middle">
			<h3 class="topTitle">
				<span>新規企業登録</span>
			</h3>
			<div class="cont_login" style="margin-bottom:0;">
				<!-- cntHeader -->
				<div class="cntCenter login">
					<ul class="attention">
						<li>貴社の会社情報をご入力下さい</li>
						<li>与信限度額が策定されましたらメールでお送りします</li>
						<li class="forgotPass">メールがとどかない場合はお問い合わせをお願いします</li>
						<li class="forgotPass"><a href="Regist">個人の方はこちらから登録</a></li>
					</ul>
				</div>
			</div>
			<form action="" method="post">
				<dl>
					<dt class="first">
						<span>必須</span><label for="company_name">会社名</label>
					</dt>
					<dd class="first">
						<input type="text" name="company_name" id="company_name" required />
					</dd>

					<dt>
						<span>必須</span><label for="phone_number">電話番号</label>
					</dt>
					<dd>
						<input type="number" name="phone_number" id="phone_number" maxlength="11" required />
					</dd>

					<dt>
						<span>必須</span><label for="email">メールアドレス</label>
					</dt>
					<dd>
						<p>
							<input type="email" name="email" id="email" required />
						</p>
						<p>
							<input type="email" name="email2" id="confirm_email" required />
							<span class="confirm">確認のためにもう一度入力してください。</span>
						</p>
					</dd>

					<dt>
						<span>必須</span><label for="post_address">郵便番号</label>
					</dt>
					<dd>
						<input type="number" name="post_address" id="post_address" maxlength="7" required />
					</dd>

					<dt>
						<span>必須</span><label for="name">区</label>
					</dt>
					<dd>
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
					</dd>

					<dt>
						<span>必須</span><label for="under_address">以下住所</label>
					</dt>
					<dd>
						<input type="text" name="under_address" id="under_address" required />
					</dd>

					<dt>
						<span>必須</span><label for="fonding_date">創立日</label>
					</dt>
					<dd>
						<input type="date" name="fonding_date" id="fonding_date" required />
					</dd>

					<dt>
						<span>必須</span><label for=""capital"">資本金</label>
					</dt>
					<dd>
						<input type="number" name="capital" id="capital" maxlength="16" required />
					</dd>

					<dt>
						<span>必須</span><label for="representative_name">代表者名</label>
					</dt>
					<dd>
						<input type="text" name="representative_name" id="representative_name" required />
					</dd>

					<dt>
						<span>必須</span><label for="password">パスワード</label>
					</dt>
					<dd>
						<input type="text" name="password" id="password" required />
					</dd>
				</dl>
				<div align="center">
					<button id="contactBtn" type="submit">登録する</button>
				</div>
			</form>
		</div>
	</div>
	<!-- cntCenter -->
</div>