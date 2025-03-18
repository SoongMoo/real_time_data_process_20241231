<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 align="center" width="600">
	<caption> 상품 상세보기</caption>
	<tr><th width="150" >상품번호</th><td></td></tr>
	<tr><th width="150" >상품명</th><td></td></tr>
	<tr><th>상품가격</th><td></td></tr>
	<tr><th>상품설명</th><td></td></tr>
	<tr><th>조회수</th><td></td></tr>
	<tr><th colspan="2">
		<a href="goodsUpdate.goods?goodsNum=">상품수정</a> | 
		<a href="goodsDelete.goods?goodsNum=">상품 삭제</a> | 
		<a href="goodsList.goods">상품목록</a></th></tr>
</table>
</body>
</html>