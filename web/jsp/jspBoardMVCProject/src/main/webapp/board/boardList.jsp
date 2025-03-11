<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// List<BoardDTO> dtos = request.getAttribute("dtos");
    // ${dtos}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
</head>
<body>
<a href="boardWrite.naver">게시글 쓰기</a><br />
게시글 목록<br />
<table border="1" width=300>
	<tr><td>번호</td><td>글쓴이</td><td>제목</td></tr>
	<c:forEach items="${dtos}" var="dto">
	<tr><td><a href="boardDetail.naver?boardNum=${dto.boardNum }">${dto.boardNum }</a></td>
		<td>${dto.boardName }</td>
		<td>${dto.boardSubject }</td></tr>
	</c:forEach>
</table>
</body>
</html>