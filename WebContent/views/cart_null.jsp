<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart-null.css">
<%@include file="header.jsp" %>

<div class="cart-null">
  <h1 class="header-logo"><a href="../jp.co.aforce.servlet/home">CART</a></h1>
  <h3>カートに商品がありません。</h3>
	<a href="home.jsp" ><button>HOME</button></a>
</div>
<%@include file="footer.html" %>