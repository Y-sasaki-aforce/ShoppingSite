<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/purchase_out.css">
<%@include file="header.jsp" %>
<hgroup>
   <h1 class="header-logo"><a href="purchase_in.jsp">PURCHASE</a></h1>
	<h3>購入商品詳細</h3>
</hgroup>
		<table class="cart-table">
			<thead>
				<tr>
					<th></th>
					<th>商品名</th>
					<th>値段</th>
					<th>個数</th>
					<th>小計</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${cart}">
					<tr>
						<td><img src="../img/${item.product.product_id}.jpg" height="200"></td>
						<td>${item.product.product_name}</td>
						<td>${item.product.product_price}円</td>
						<td>${item.count}セット</td>
						<td>小計:${item.product.product_price*item.count}円</td>
					</tr>
					<tr>
						<!-- 合計値を求めるコード -->
						<!-- 合計値を初期化 -->
						<c:set var="total" value="${0}"/>
						<c:forEach var="item" items="${cart}">
						    <c:set var="total" value="${total + item.product.product_price*item.count}" />
						</c:forEach>

				</c:forEach>

				<tr class="total">
					<th>合計</th>
					<td>${total}円</td>
				</tr>
			</tbody>
		</table>

	<form action="../jp.co.aforce.servlet/purchase-action" method="post">

		<h3>♦お支払方法を選択してください。</h3>
		<p>
			現金<input type="radio" name="payment" value="1">
			クレジットカード<input type="radio" name="payment" value="2">
		</p>

		<h3>♦以下の住所に配達致します。</h3>

		<p>
		『${user.address}』
		</p>

		<div class="purchase_btn">
		<input type="submit" value="購入確定" class="btns submit">
		</div>
	</form>

	<p><a href="purchase_in.jsp"><button type="button" >戻る</button></a></p>

<%@include file="footer.html" %>