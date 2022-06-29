<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/purchase_in.css">
<%@include file="header.jsp" %>

<div id="slider">
	<div class="wrapper">
		<!-- toggle_btn -->
		 <div id="gnav-area">
		     <nav class="gnav">
		       <div class="inner">
		       <ul class="gnav-list">
		       	<li class="gnav-item"><a href="home.jsp">HOME</a></li>
		         <li class="gnav-item"><a href="product_info.jsp">PRODUCT</a></li>
		         <li class="gnav-item"><a href="../jp.co.aforce.servlet/preview-action">CART</a></li>
		         <li class="gnav-item"><a href="contact.jsp">CONTACT</a></li>
		       </ul>
		       </div>
		     </nav>

		 <div class="toggle_btn">
			    <span></span>
			    <span></span>
			    <span></span>
			</div>
			<div id="mask"></div>
		</div>

			<h1 class="header-logo"><a href="../jp.co.aforce.servlet/home">CART</a></h1>
			<p>${cart.size()}点の商品があります。</p>

			<table class="cart-table">
				<thead>
					<tr>
						<th></th>
						<th>商品名</th>
						<th>個数</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${cart}">
						<tr>
						<td><img src="../img/${item.product.product_id}.jpg" height="200"></td>
						<td>${item.product.product_name}</td>
						<td>${item.count}セット</td>

						<td><a href="../jp.co.aforce.servlet/cart-remove?id=${item.product.product_id}"><button type="button" >取消</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			${msg}
			<form action="../jp.co.aforce.servlet/purchase-in" method="post">
				<div class="purchase_btn">
				<input type="submit" value="レジに進む" class="btns submit">
				</div>
			</form>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/purchase_in.js"></script>
<%@include file="footer.html" %>