<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<%@include file="header.jsp" %>

<hgroup>
  <h1>ユーザー新規登録</h1>
  <h3>THE WEST FACE</h3>
</hgroup>

<form action="../jp.co.aforce.servlet/user-regist" method="post">

		<div class="group">
			 <input type="text" name="name" id="name" placeholder="Name">
			 <span class="highlight"></span><span class="bar"></span>
		</div>

		<div class="group">
			 <input type="email" name="mail_address" id="mail_address" placeholder="Email">
			 <span class="highlight"></span><span class="bar"></span>
		</div>

		<div class="group">
			 <input type="text" name="address" id="address" placeholder="Address">
			 <span class="highlight"></span><span class="bar"></span>
		</div>

		<div class="group">
			 <input type="password" name="password" id="password" placeholder="Password">
			 <span class="highlight"></span><span class="bar"></span>
		</div>

		<p>${msg}<a href="../jp.co.aforce.servlet/user-regist">ログインへ</a></p>
		<button type="submit" id="submit" class="button buttonBlue">登録
			<div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
		</button>
</form>

<script src="${pageContext.request.contextPath}/js/script.js"></script>

<%@include file="footer.html" %>