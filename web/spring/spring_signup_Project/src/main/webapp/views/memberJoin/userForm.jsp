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
회원정보 등록<br />
<form:form action="userWrite" method="post" modelAttribute="memberCommand">
<table border=1 width=600>
	<tr><td>회원아이디</td>
		<td><form:input path="memberId" />      <form:errors path="memberId" /></td></tr>
	<tr><td>회원비밀번호</td>
		<td><form:password path="memberPw" />   <form:errors path="memberPw" /></td></tr>
	<tr><td>회원비밀번호</td>
		<td><form:password path="memberPwCon" /><form:errors path="memberPwCon" /></td></tr>
	<tr><td>회원이름</td>
		<td><form:input path="memberName" />    <form:errors path="memberName" /></td></tr>
	<tr><td>회원이메일</td>
		<td><input type="email" name="memberEmail" value="${memberCommand.memberEmail }"/>
												<form:errors path="memberEmail" /></td></tr>
	<tr><th colspan="2">
			<input type="submit" value="회원등록" />
			<input type="button" value="회원가입취소" 
				   onclick="javascript:location.href='/'"> 
		</th></tr>
</table>
</form:form>
</body>
</html>