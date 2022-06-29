<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">
<%@include file="header.jsp" %>

<div id="slider">
	<main>
	   <div class="mv">
	        <div class="mv-container">
	          <p class="mv-title">
	          	<span >T</span>
	          	<span>H</span>
	          	<span>E</span>
	          	<span>&nbsp;</span>
	          	<span>W</span>
	  			<span>E</span>
	  			<span>S</span>
	  			<span>T</span>
	  			<span>&nbsp;</span>
	  			<span>F</span>
	  			<span>A</span>
	  			<span>C</span>
	  			<span>E</span>
	         </p>
	          <p class="mv-subtitle header-logo my-parts"><a href="product_info.jsp">公式オンラインストア</a></p>
	          <nav id="global_navi" >
					<ul>
						<li><a href="../jp.co.aforce.servlet/product-action" class="btn btn-malformation">PRODUCT</a></li>

						<li><a href="../jp.co.aforce.servlet/preview-action" class="btn btn-malformation">CART</a></li>

						<li><a href="../jp.co.aforce.servlet/history" class="btn btn-malformation">ORDER</a></li>

						<li><a href="profile.jsp" class="btn btn-malformation">PROFILE</a></li>

					</ul>
				</nav>
	          <button onclick="MoveCheck();" class="btn btn-malformation">
				  Logout
			</button>
			</div>
		</div>
	</main>

	<h3><a href="contact.jsp" class="btn btn--orange btn-c"><i class="fa fas fa-envelope"></i>CONTACT</a></h3>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/home.js"></script>
<%@include file="footer.html" %>