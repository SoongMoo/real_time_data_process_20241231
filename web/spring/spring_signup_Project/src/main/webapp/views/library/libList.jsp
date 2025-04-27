<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
자료실 <br />
<a href="libWrite">자료등록</a>
<table border=1 width=600>
	<tr><th>번호</th><th>글쓴이</th><th>제목</th><th>등록일</th></tr>
	<c:forEach items="${list }" var="dto">
	<tr><th>${dto.libNum }</th>
		<th><a href="libInfo?libNum=${dto.libNum }">${dto.libWriter }</a></th>
		<th><a href="libInfo?libNum=${dto.libNum }">${dto.libSubject }</a></th>
		<th>등록일</th></tr>
	</c:forEach>
</table>
</body>
</html>



