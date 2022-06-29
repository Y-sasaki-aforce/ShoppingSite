<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<h1>新規登録画面</h1>

<form action="../jp.co.aforce.servlet/user-regist" method="post">

		<p>◆Name
			 <input type="text" name="name" >
		</p>

		<p>◆E-mail
			 <input type="text" name="mail_address" >
		</p>

		<p>◆Address
			 <input type="text" name="address" >
		</p>

		<p>◆Password
			 <input type="text" name="password" >
		</p>

<button type="submit">登録</button>
</form>

<form action="../jp.co.aforce.servlet/user-login" method="post">
<button type="submit">ログインへ</button>
</form>

<%@include file="footer.html" %>