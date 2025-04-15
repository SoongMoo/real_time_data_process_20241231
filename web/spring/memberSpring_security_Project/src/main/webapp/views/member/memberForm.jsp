<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원정보 등록<br />
<form action="memberWrite" method="post">
<table border=1 width=600>
	<tr><td>회원번호</td>
		<td><input type="text" name="memberNum" value="${memberNum }" readonly="readonly"/>자동부여</td></tr>
	<tr><td>회원아이디</td>
		<td><input type="text" name="memberId" /></td></tr>
	<tr><td>회원비밀번호</td>
		<td><input type="password" name="memberPw" /></td></tr>
	<tr><td>회원이름</td>
		<td><input type="text" name="memberName" /></td></tr>
	<tr><th colspan="2">
			<input type="submit" value="회원등록" />
			<input type="button" value="회원리스트" 
				   onclick="javascript:location.href='memberList'"> 
		</th></tr>
</table>
</form>
</body>
</html>


