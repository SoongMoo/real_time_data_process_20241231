<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty auth}">
<a href="employee/empList">직원목록</a><br />
<a href="login/logout">로그아웃</a>
</c:if>

<c:if test="${empty auth}">
<form:form modelAttribute="loginCommand" action="/login/login" method="post">
<table border = 1>
	<tr><td colspan="2">
			자동로그인<input type="checkbox" name="autoLogin"/> | 
			아이디저장<input type="checkbox" name="idStore"/> 
		</td></tr>
	<tr>
		<td><form:input path="userId" /><form:errors path="userId" /></td>
		<td rowspan="2"><input  type="submit" value="로그인" /></td>
	</tr>
	<tr>
		<td><form:password path="userPw" /><form:errors path="userPw" /> </td>
	</tr>
	<tr><td colspan="2">
			<a href="#">아이디</a>/<a href="#">비밀번호</a>찾기 | <a href="#">회원 가입</a>
		</td></tr>
</table>
</form:form>
</c:if>
</body>
</html>