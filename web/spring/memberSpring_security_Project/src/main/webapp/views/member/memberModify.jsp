<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberUpdate" method="post">
<table border=1 width=600>
	<tr><td>회원번호</td>
		<td><input type="text" name="memberNum" value="${dto.memberNum }" readonly="readonly"/>자동부여</td></tr>
	<tr><td>회원아이디</td>
		<td><input type="text" name="memberId" value="${dto.memberId }"/></td></tr>
	<tr><td>회원비밀번호</td>
		<td><input type="password" name="memberPw" />
			<span style="color:red">${pwErr }</span></td></tr>
	<tr><td>회원이름</td>
		<td><input type="text" name="memberName" value="${dto.memberName }"/></td></tr>
	<tr><th colspan="2">
			<input type="submit" value="회원수정완료" />
			<input type="button" value="회원리스트" 
				   onclick="javascript:location.href='memberList'"> 
		</th></tr>
</table>
</form>
</body>
</html>