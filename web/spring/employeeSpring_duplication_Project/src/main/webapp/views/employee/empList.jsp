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
직원 목록<br />
<a href="empWrite">직원 등록</a><br />
<table border=1 width=600 >
	<tr><td>번호</td><td>직원번호</td><td>이름</td><td>아이디</td></tr>
	<c:forEach items="${list }" var="dto" varStatus="idx">
		<tr><td>${idx.count }</td>
			<td><a href="empDetail?empNum=${dto.empNum }">${dto.empNum }</a></td>
			<td><a href="empDetail?empNum=${dto.empNum }">${dto.empName }</a></td>
			<td>${dto.empId }</td></tr>
	</c:forEach>
</table>
</body>
</html>