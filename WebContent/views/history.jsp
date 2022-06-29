<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/rireki.css">
<%@include file="header.jsp" %>
<div class="delete">

<hgroup>
<h1 class="header-logo"><a href="../jp.co.aforce.servlet/home">ORDER</a></h1>
<h3></h3>
</hgroup>

<table class="cart-table">
			<thead>
				<tr>
					<th>購入日時</th>
					<th></th>
					<th>商品名</th>
					<th>料金</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${product_list}">
					<tr>
						<td>${p.order_date}</td>
						<td><img src="../img/${p.product_id}.jpg" height="200"></td>
						<td>${p.product_name}</td>
						<td>${p.product_price}円</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<div class="history">
			<form action="../jp.co.aforce.servlet/history" method="post">
				<button type="submit" id="submit">HOME</button>
			</form>
		</div>
</div>
<%@include file="footer.html" %>