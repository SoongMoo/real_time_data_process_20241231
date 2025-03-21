<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800">
	<tr><td rowspan="4"><img src="goods/upload/${dto.goodsMainStoreImage }" width="200" /></td>
		<td> ${dto.goodsName } </td></tr>
	<tr><td> ${dto.goodsPrice } </td></tr>
	<tr><td> ${dto.visitCount } </td></tr>
	<tr><td>
		<button type="button" id="cartBtn">장바구니</button> | 
 		<button type="button" id="buyItem">바로구매 </button> | 
 		찜
		</td></tr>
<tr><td colspan="2">
		<div id="content">
			${dto.goodsContent }<br />
			<c:forTokens items="${dto.goodsDetailStoreImage }" delims="`" var="image">
				<img src="goods/upload/${image }" />
			</c:forTokens>
		</div>
	</td></tr>
</table>
</body>
</html>