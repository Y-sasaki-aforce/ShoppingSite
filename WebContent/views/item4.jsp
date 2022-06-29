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
				<c:when test="${p.product_id == 4}">
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
								誰もが憧れる一流の登山用品で揃えた富士登山向け7点セット。
								セット内の商品は、THE NORTH FACEだけのセットで登山上級者にも自慢できる内容です!
								超コンパクトなのに暖かい山ダウン付きでご来光待ちもばっちり。
								富士山山頂は夏でも氷点下近くまで気温が下がることがあるのです。
								レインウェアはゴアテックスモデルで雨天でもさらっと快適。
								オリジナルトートバックでのお渡しで持ち運びも便利です。
								セット総額約2.7万円相当となります。
							</p>
				</c:when>
			</c:choose>
		</c:forEach>

				<div class="home-link">
		        	<a href="item4.jsp">PRODUCT</a>
		      	</div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/item.js"></script>
<%@include file="footer.html" %>