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
게시글 목록<br />
<a href="boardWrite">게시글 쓰기</a><br />
<table border=1 width=600>
	<tr><td>번호</td><td>글쓴이</td><td>내용</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td><a href="boardDetail?boardNum=${dto.boardNum}">${dto.boardNum}</a></td>
		<td><a href="boardDetail?boardNum=${dto.boardNum}">${dto.boardWriter}</a></td>
		<td>${dto.boardSubject}</td></tr>
	</c:forEach>
</table>
</body>
</html>