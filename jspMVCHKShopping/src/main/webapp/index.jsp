<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
한경 쇼핑몰<br />
<c:if test="${!empty auth }">
<ul>
	<c:if test="${auth.grade == 'emp' }">
		<li><a href="memberList.mem">회원관리</a></li>
		<li><a href="employeeList.emp">직원관리</a></li>
		<li><a href="empMyPage.my">내정보 보기</a></li>
		<li><a href="goodsList.goods">상품관리</a></li>
	</c:if>
	<c:if test="${auth.grade == 'mem' }">
		<li><a href="memberMyPage.my">내정보 보기</a></li>
		<li><a href="cartList.item">장바구니</a></li>
		<li><a href="purchaseList.item">주문조회</a></li>
	</c:if>
	<li><a href="logout.login">로그아웃</a></li>
</ul>
</c:if>

<c:if test="${empty auth }">
<form action="login.login" method="post" id="frm">
<table border="1" align="center">
	<tr><td colspan="2">
		<input type="checkbox" name="keepLogin"/> 로그인유지 | 
		<input type="checkbox" name="storeId" value="store" 
					<c:if test="${!empty sid }">checked</c:if> />아이디저장</td></tr>
	<tr><td><input type="text" placeholder="아이디" name="userId" value="${sid }"/>
			<span style="color:red">${idErr }</span>
		</td>
		<td rowspan="2"><input type="submit" value="로그인"/></td></tr>
	<tr><td><input type="password" placeholder="8~12자리 비밀번호" name="userPw"/>
			<span style="color:red">${pwErr }</span></td></tr>
	<tr><td colspan="2">아이디 / 비밀번호 찾기 | 
	                    <a href="userAgree.nhn">회원가입</a></td></tr>
</table>
</form>
</c:if>

<table width=800 align="center">
	<tr>
		<c:forEach items="${list }" var="dto" varStatus="idx">
		<td>
		<a href="detailView.item?goodsNum=${dto.goodsNum }">
			<img src="goods/upload/${dto.goodsMainStoreImage }" width=300 height=150/><br />
			${dto.goodsName }<br /> 
			${dto.goodsPrice }<br />
		</a>
		</td>
		<c:if test="${idx.count % 3 == 0 }"></tr><tr></c:if>
		</c:forEach>
	</tr>
</table>

</body>
</html>







