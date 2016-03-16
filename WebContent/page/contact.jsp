<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="cont_contact"><!-- cntHeader -->
			<div class="cntCenter contact">
                <p class="backShop"><a href="./">ショップへ戻る</a></p>
				<div class="middle">
                    <h3 class="topTitle"><span>お問合せ</span></h3>
                    <p class="info">当店に対するご意見ご感想、お問い合わせなど、こちらのフォームよりお気軽にお尋ねください。</p>
                    <form action="" method="post">
                        <dl>
                            <dt class="first"><span>必須</span><label for="name">お名前</label></dt>
                            <dd class="first"><input type="text" name="name" id="name" required/></dd>
                            <dt><span>必須</span><label for="email">メールアドレス</label></dt>
                            <dd>
                                <p><input type="email" name="email" id="email" required/></p>
                                <p>
                                    <input type="email" name="email2" id="confirm_email" required/>
                                    <span class="confirm">確認のためにもう一度入力してください。</span>
                                </p>
                            </dd>
                            <dt><span>必須</span><label for="title">お問合せタイトル</label></dt>
                            <dd><input type="text" name="title" id="title" required/></dd>
                            <dt><span>必須</span><label for="inquiry">お問合せ内容</label></dt>
                            <dd><textarea name="inquiry" id="inquiry" rows="10" cols="30" required></textarea></dd>
                        </dl>
                        <div align="center"><button id="contactBtn" type="submit">送信する</button></div>
                    </form>
				</div>
			</div>
			<!-- cntCenter -->
		</div>




