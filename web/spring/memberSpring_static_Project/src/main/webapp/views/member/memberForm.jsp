<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src ="/static/js/daumAddressScript.js"></script>
</head>
<body>
회원등록<br />
<form action="memberWrite" method="post">
<table border=1 width=600>
	<tr><th>회원번호</th>
		<td><input type="text" name="memNum" value="${memberNum }"/></td></tr>
	<tr><th>회원아이디</th>
		<td><input type="text" name="memId"/></td></tr>
	<tr><th>회원비밀번호</th>
		<td><input type="password" name="memPw"/></td></tr>
	<tr><th>회원이름</th>
		<td><input type="text" name="memName"/></td></tr>
	<tr><th>회원주소</th>
		<td><input type="text" name="memAddr" id="sample4_roadAddress"/>
			<button type="button" onclick="execDaumPostcode();">주소검색</button></td></tr>
	<tr><th>회원상세주소</th>
		<td><input type="text" name="memDetailAddr"/></td></tr>
	<tr><th>우편번호</th>
		<td><input type="text" name="memPost" id="sample4_postcode"/></td></tr>
	<tr><th>생년월일</th>
		<td><input type="date" name="memBirth"/></td></tr>
	<tr><th colspan="2"><input type="submit" value="등록">
			<input type="button" value="목록으로" 
				   onclick="javascript:location.href='memberList'" />
		</th></tr>
</table>
</form>
</body>
</html>