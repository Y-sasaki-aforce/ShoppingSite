<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<h1>商品変更画面</h1>

	${msg}

	<form action="../jp.co.aforce.servlet/product-update" method="post">

		<p>変更する商品を入力してください</p>

		<p>商品番号<input type="text" name="product_id" required></p>

		<p>商品名<input type="text" name="product_name" required></p>

		<p>価格<input type="text" name="product_price" required></p>

		<button type="submit" id="submit">更新</button>
	</form>


	<form action="../jp.co.aforce.servlet/product-delete" method="post">

		<p>削除する商品の番号を入力してください</p>

		<p>商品番号<input type="text" name="product_id" required></p>

		<button type="submit" id="submit">削除</button>
	</form>

		<p><a href="../jp.co.aforce.servlet/product-delete"><button type="button" >戻る</button></a></p>


<%@include file="footer.html" %>