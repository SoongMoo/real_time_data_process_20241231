<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요<br />
<form:form modelAttribute="loginCommand" action="/login/login" method="post">
<table border=1 >
	<tr><td colspan="2">
			자동로그인 | 아이디저장
		</td></tr>
	<tr><td><form:input path="userId"/><form:errors path="userId"/></td>
		<td rowspan="2"><input type="submit"  value="로그인"/></td></tr>
	<tr><td><form:password path="userPw" /><form:errors path="userPw" /></td></tr>
	<tr><td colspan="2">
		아이디/비밀번호찾기	| 
		<a href="/register/userAgree">회원가입</a>
		</td></tr>
</table>
</form:form>
</body>
</html>