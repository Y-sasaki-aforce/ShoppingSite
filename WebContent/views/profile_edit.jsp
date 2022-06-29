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
		  <h1 class="header-logo"><a href="profile.jsp">PROFILE</a></h1>
		  <h3>${user.name}さん</h3>
		</hgroup>
			${msg}

				<form action="../jp.co.aforce.servlet/user-update" method="post">

				<h3>Name</h3>
				<div class="group">
					 <input type="text" name="name" id="name" value="${user.name}">
					 <span class="highlight"></span><span class="bar"></span>
				</div>

				<h3>E-mail</h3>
				<div class="group">
					 <input type="email" name="mail_address" id="mail_address" value="${user.mail_address}">
					 <span class="highlight"></span><span class="bar"></span>
				</div>

				<h3>Address</h3>
				<div class="group">
					 <input type="text" name="address" id="address" value="${user.address}">
					 <span class="highlight"></span><span class="bar"></span>
				</div>

				<h3>Password</h3>
				<div class="group">
					 <input type="password" name="password" id="password" placeholder="Password" required>
					 <span class="highlight"></span><span class="bar"></span>
				</div>

				<button type="submit" id="submit" class="button buttonBlue" onclick="MoveCheck2();">保存
					<div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
				</button>
				</form>


				<div class="home-link">
		            <a href="profile.jsp">profile</a>
		     	</div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/profile-edit.js"></script>
<%@include file="footer.html" %>