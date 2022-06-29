<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/item.css">
<%@include file="header.jsp" %>

<div id="slider">
	<div class="wrapper">
	<!-- toggle_btn -->
		 <div id="gnav-area">
		     <nav class="gnav">
		       <div class="inner">
		       <ul class="gnav-list">
		       	<li class="gnav-item"><a href="../jp.co.aforce.servlet/home">HOME</a></li>
		         <li class="gnav-item"><a href="../jp.co.aforce.servlet/preview-action">CART</a></li>
		         <li class="gnav-item"><a href="../jp.co.aforce.servlet/profile">PROFILE</a></li>
		         <li class="gnav-item"><a href="../jp.co.aforce.servlet/contact" >CONTACT</a></li>
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
		<c:forEach var="p" items="${product_list}">
			<c:choose>
				<c:when test="${p.product_id == 8}">
					<hgroup>
					  <h1 class="header-logo my-parts"><a href="../jp.co.aforce.servlet/product-action">PRODUCT</a></h1>
					  <h3>${p.product_name}</h3>
					</hgroup>
						<table>
							<tr>
					    		<td><a><img src="../img/${p.product_id}.jpg"></a></td>
					    		<td id="product_price">￥${p.product_price}</td>
							</tr>
						</table>
						<div class="cart-add">
							<a href="../jp.co.aforce.servlet/cart-add?id=${p.product_id}" class="btn btn-tag"><i class="fas fa-shopping-cart"></i>カートに追加</a>
						</div>

						<h2>商品説明</h2>
							<p>
								大人気のキッズ向け富士山登山セット(レインウェア上下・ザック・ダウンジャケット・トレッキングシューズ)に加えて、トレッキングポール・スパッツ・ヘッドライトを追加した7点セットのフルバージョン！大人向けの富士山登山セットと同じアイテム数のセットです。
								一流登山用品ブランドであるモンベルやブラックダイアモンド、ペツルなどの本格派アイテムで取り揃え、品質と使いやすさは大人も顔負けです。
								トレッキングポール・スパッツ・ヘッドライトは大人用と共用アイテムとなる場合がございますが、キッズでも使える重さやサイズの商品にてご用意致します。キッズセットは目安として小学校高学年までが対象です。それ以上は大人用のSサイズ等をご利用くださいませ。
							</p>
				</c:when>
			</c:choose>
		</c:forEach>

				<div class="home-link">
		        	<a href="item8.jsp">PRODUCT</a>
		      	</div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/item.js"></script>
<%@include file="footer.html" %>