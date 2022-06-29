<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>

<c:choose>
<c:when test="${user.member_id == 1 }">
	<h1>商品登録画面</h1>

		<p>追加する商品を入力してください</p>
			${msg}
			<form action="../jp.co.aforce.servlet/product-regist" method="post">
				<p>商品名<input type="text" name="product_name" required></p>
				<p>価格<input type="text" name="product_price" required></p>
				<button type="submit" id="submit">登録</button>
			</form>

			<p><a href="product_info2.jsp"><button type="button" >一覧</button></a></p>

			<form action="../jp.co.aforce.servlet/product-regist" method="get">
				<button type="submit" id="submit">編集</button>
			</form>

		<p><a href="../jp.co.aforce.servlet/user-logout"><button type="button" >ログアウト</button></a></p>

</c:when>
<c:otherwise>
<a href="home.jsp"></a>
</c:otherwise>
</c:choose>


<%@include file="footer.html" %>