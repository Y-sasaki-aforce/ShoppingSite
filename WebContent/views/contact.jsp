<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/renraku.css">
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
			<h1 class="header-logo my-parts"><a href="home.jsp">CONTACT</a></h1>
			<h3>ACCESS</h3>
		</hgroup>
			<div class="map">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3241.111456900017!2d139.70650190000003!3d35.674257499999996!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188cbc77cfc555%3A0x8616d5c79d061f31!2z44CSMTUwLTAwMDEg5p2x5Lqs6YO95riL6LC35Yy656We5a6u5YmN77yR5LiB55uu77yR4oiS77yR77yS!5e0!3m2!1sja!2sjp!4v1649654220535!5m2!1sja!2sjp" width="600" height="450" style="border:0;"></iframe>
			</div>
			<br>
			<hgroup>
				<h3>SNS</h3>
			</hgroup>
			<div class="sns_btn">
				<!-- instagram -->
				 <ul class="socialEffect__box">
			        <li>
			          <a class="socialEffect__link icon-instagram" href="https://instagram.com/thenorthface?igshid=YmMyMTA2M2Y=?ref=badge"
			            ><i class="fab fa-instagram"></i
			          ></a>
			        </li>
			        <li>
			          <a class="socialEffect__link icon-facebook" href=""
			            ><i class="fab fa-facebook-f"></i
			          ></a>
			        </li>
			        <li>
			          <a class="socialEffect__link icon-twitter" href="https://twitter.com/@thenorthfacejp"
			            ><i class="fab fa-twitter"></i
			          ></a>
			        </li>
			      </ul>
		    </div>

			<div class="home-link">
		            <a href="home.jsp">HOME</a>
		    </div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vegas/2.5.4/vegas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/cont.js"></script>
<%@include file="footer.html" %>