<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		//csr
		$("#cartBtn").click(function() {
			$.ajax({
				type : "post",
				url : "cart.item",
				data : {
					"goodsNum" : "${dto.goodsNum }",
					"cartQty" : $("#cartQty").val()
				},
				success : function() {
					con = confirm("장바구니로 이동하시겠습니까?");
					if (con) location.href = "cartList.item";
				},
				error : function() {
					window.open("loginCk.login","이름"
							,"width=400, height=100 , top=100, left=100");
				}
			});
		});
		$("#wish").click(function() {
			// ssr은 페이지를 이동한다. : 동기식
			// csr은 페이지가 이동하지 않고 현페이지 유지: 비동기식
			// ajax()의 인자는 json이다.
			// html의 json은 {"키","값",...,"키n":"값n"}
			$.ajax({
				type : "post",
				url : "wishItem.item",
				data : {
					"goodsNum" : "${dto.goodsNum}"
				},
				success : function() {
					if ($("#wish").attr("src") == "images/hart1.jpg") {
						$("#wish").attr("src", "images/hart.jpg")
					} else {
						$("#wish").attr("src", "images/hart1.jpg")
					}
				},
				error : function() {
					alert('로그 아웃 되었습니다.\n다시 로그인 해 주세요.');
					location.href = "<c:url value='/' />";
				}
			});
		});
	});
</script>
</head>
<body>

	<table width="800">
		<tr>
			<td rowspan="5"><img
				src="goods/upload/${dto.goodsMainStoreImage }" width="200" /></td>
			<td>${dto.goodsName }</td>
		</tr>
		<tr>
			<td><fmt:formatNumber value="${dto.goodsPrice }"
					pattern="###,###,###" type="currency" />원</td>
		</tr>
		<tr>
			<td>조회수 : ${dto.visitCount }</td>
		</tr>
		<tr>
			<td>수량 : <input type="number" min=1 value=1 step=1 id="cartQty" />
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" id="cartBtn">장바구니</button> |
				<button type="button" id="buyItem">바로구매</button> | <c:if
					test="${empty wish }">
					<img src="images/hart1.jpg" width=20 id="wish" />
				</c:if> <c:if test="${!empty wish }">
					<img src="images/hart.jpg" width=20 id="wish" />
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="content">
					${dto.goodsContent }<br />
					<c:forTokens items="${dto.goodsDetailStoreImage }" delims="`"
						var="image">
						<img src="goods/upload/${image }" />
					</c:forTokens>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>