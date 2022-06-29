<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css">
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

		<hgroup>
		  <h1 class="header-logo my-parts"><a href="home.jsp">PROFILE</a></h1>
		  <h3>${user.name}さん</h3>
		</hgroup>

			<form action="profile_edit.jsp" class="profile" method="get">
			<h3>Name</h3>
			<div class="group">
				${user.name}<br>
				<span class="highlight"></span><span class="bar"></span>
			</div>

			<h3>E-mail</h3>
			<div class="group">
				${user.mail_address}<br>
				<span class="highlight"></span><span class="bar"></span>
			</div>

			<h3>Address</h3>
			<div class="group">
				${user.address}<br>
				<span class="highlight"></span><span class="bar"></span>
			</div>

			<button type="submit" id="submit" class="button buttonBlue">編集
			<div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
			</button>

			</form>

			<h3>アカウント削除</h3>

			<form action="../jp.co.aforce.servlet/user-delete" method="post">
				<div class="group">
					<input type="password" name="password" id="password" placeholder="Password"  required><br>
					<span class="highlight"></span><span class="bar"></span>
				</div>

				<button type="submit" id="submit" class="button buttonBlue">削除
				<div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
				</button>
			</form>

			<div class="home-link">
		            <a href="home.jsp">HOME</a>
		     </div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/profile.js"></script>
<%@include file="footer.html" %>