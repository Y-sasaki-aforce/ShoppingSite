<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<%@include file="header.jsp" %>

<hgroup>
  <h1>THE WEST FACE</h1>
  <h3>公式オンラインストア</h3>
</hgroup>

<form action="../jp.co.aforce.servlet/user-login" method="post">
	<div class="group">
		<input type="email" name="mail_address" id="mail_address" placeholder="Email" required><br>
		<span class="highlight"></span><span class="bar"></span>
	</div>

	<div class="group">
		<input type="password" name="password" id="password" placeholder="Password"  required><br>
		<span class="highlight"></span><span class="bar"></span>
	</div>
	<p>
	${error_msg}
	</p>

	<p>まだ会員登録がお済でない方は
	<a href="../jp.co.aforce.servlet/user-login">こちら</a>

	<button type="submit" id="submit" class="button buttonBlue">ログイン
	<div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
	</button>

</form>

<%@include file="footer.html" %>