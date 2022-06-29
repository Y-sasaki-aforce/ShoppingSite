<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product-info.css">
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

		<main>
			<h1 class="header-logo my-parts"><a href="../jp.co.aforce.servlet/home">PRODUCT</a></h1>

				<nav id="global_navi" >
				<ul>
					<li><a href="../jp.co.aforce.servlet/product-action" class="btn btn-malformation">すべて</a></li>

					<li><a href="../jp.co.aforce.servlet/product-action-mens" class="btn btn-malformation">Mens</a></li>

					<li><a href="../jp.co.aforce.servlet/product-action-women" class="btn btn-malformation">Women</a></li>

					<li><a href="../jp.co.aforce.servlet/product-action-kids" class="btn btn-malformation">Kids</a></li>

				</ul>
				</nav>

				<section>
					<form action="../jp.co.aforce.servlet/product-action"  method="get">
						<input class="textbox" type="text" name="keyword" placeholder="Search" autocomplete="off" maxlength="60">
						<br>
						<div class="selectdiv">
							<select id="select" onChange="movePage();">
							 	<option value="#">--</option>
							 	<option value="1">すべて</option>
								<option value="2">価格の高い順</option>
				          		<option value="3">価格の低い順</option>
							</select>
						</div>
					</form>
					<br>

					${msg}

						<table>
								<c:forEach var="p" items="${product_list}">
								  <tr>
								    <th>${p.product_name}</th>
								  </tr>
								  <tr>
								  	<td>
								  	<a href="<c:url value="../jp.co.aforce.servlet/product-check" >
								  		<c:param name="id" value="${p.product_id}" />
			 							</c:url>"><img src="../img/${p.product_id}.jpg" height="200" class="ImgBox-Img">
			 						</a>
			 						</td>
			 					  </tr>

								  <tr>
								    <td id="product_price">￥${p.product_price}</td>
								  </tr>
								</c:forEach>
						</table>
					<br/>

					<div class="home-link">
			        	<a href="../jp.co.aforce.servlet/product-action">TOP</a>
			      	</div>
				</section>
				<footer>
				  	  <small>Copyright 2022 THE WEST FACE</small>
				</footer>
		</main>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/product_info.js"></script>
<%@include file="footer.html" %>