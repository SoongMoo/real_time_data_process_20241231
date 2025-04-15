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
회원 목록<br />
<a href="memberWrite">회원 등록</a><br />
<table border=1 width=600>
	<tr><th>번호</th><th>이름</th><th>아이디</th></tr>
	<c:forEach items="${list }" var="dto" varStatus="idx">	
		<tr><th>${idx.count }</th>
			<th><a href="memberDetail?memberNum=${dto.memberNum }">${dto.memberName }</a></th>
			<th><a href="memberDetail?memberNum=${dto.memberNum }">${dto.memberId }</a></th></tr>
	</c:forEach>
</table>
</body>
</html>




