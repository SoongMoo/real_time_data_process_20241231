<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsList.jsp</title>
</head>
<body>
<a href="goodsWrite.goods">상품 추가</a><br />
<table border=1 width="600" align="center">
	<caption>상품 목록</caption>
	<tr><th>번호</th><th>상품번호</th><th>상품명</th><th>상품가격</th></tr>
	<c:forEach items="${list }" var="dto" varStatus="idx"> 
	<tr><th>${idx.count}</th>
		<th><a href="goodsDetail.goods?goodsNum=${dto.goodsNum }">${dto.goodsNum }</a></th>
		<th>${dto.goodsName }</th>
		<th>${dto.goodsPrice }</th></tr>
	</c:forEach>
</table>
</body>
</html>


