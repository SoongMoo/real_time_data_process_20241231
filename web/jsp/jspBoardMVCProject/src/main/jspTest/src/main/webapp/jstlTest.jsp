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
<table border=1 width=300>
	<tr><td>이름</td><td>주소</td><td>전화</td></tr>
	<c:forEach begin="0" end="10" step="1">
	<tr><td>1</td><td>2</td><td>3</td></tr>
	</c:forEach>
</table>
</body>
</html>