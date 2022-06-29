<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
<%@include file="header.jsp" %>

<div class="welcome">
<h1>ようこそ、${user.name} さん！</h1>
<a href="../jp.co.aforce.servlet/account-check" class="btn btn--circle"><br>Welcome!!<i class="fas fa-angle-down fa-position-bottom"></i></a>
</div>

<%@include file="footer.html" %>