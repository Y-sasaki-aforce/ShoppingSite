<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<h1>商品一覧</h1>


			<form action="../jp.co.aforce.servlet/product-action2"  method="post">
				<input type= "text" name="keyword">
			<input type="submit" value="検索">
			</form>

			<table>
			  <tr>
			  	<th>id</th>
			    <th>name</th>
			    <th>price</th>
			  </tr>
			<c:forEach var="p" items="${product_list2}">
			  <tr>
			  	<td>${p.product_id}</td>
			    <td>${p.product_name}</td>
			    <td>${p.product_price }</td>
			  </tr>
			</c:forEach>

			</table>
			<br/>

	<p><a href="../jp.co.aforce.servlet/product-action2"><button type="button" >戻る</button></a></p>

<%@include file="footer.html" %>