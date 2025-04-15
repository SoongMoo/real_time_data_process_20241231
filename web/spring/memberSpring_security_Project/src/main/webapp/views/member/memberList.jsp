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
회원리스트<br />
<a href="memberWrite">회원등록</a><br />
<table border=1 width=600 >
	<tr><th>번호</th><th>이름</th></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td width="200"><a href="memberDetailt?memberNum=${dto.memberNum }">${dto.memberNum }</a></td>
					<td><a href="memberDetailt?memberNum=${dto.memberNum }">${dto.memberName }</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>