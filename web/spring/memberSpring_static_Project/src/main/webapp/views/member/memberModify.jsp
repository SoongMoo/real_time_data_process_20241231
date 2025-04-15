<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src ="/static/js/daumAddressScript.js"></script>
</head>
<body>
<form action="memberUpdate" method="post">
<table border=1 width=600>
	<tr><th>회원번호</th>
		<td><input type="text" name="memNum" value="${dto.memberNum }" readonly="readonly"/></td></tr>
	<tr><th>회원아이디</th>
		<td><input type="text" name="memId" value="${dto.memberId }" readonly="readonly"/></td></tr>
	<tr><th>회원비밀번호</th>
		<td><input type="password" name="memPw" />
			<span style="color:red">${pwErr }</span>
			</td></tr>
	<tr><th>회원이름</th>
		<td><input type="text" name="memName" value="${dto.memberName }" /></td></tr>
	<tr><th>회원주소</th>
		<td><input type="text" name="memAddr" id="sample4_roadAddress" value="${dto.memberAddr }"/>
			<button type="button" onclick="execDaumPostcode();">주소검색</button></td></tr>
	<tr><th>회원상세주소</th>
		<td><input type="text" name="memDetailAddr" value="${dto.memberAddrDetail }"/></td></tr>
	<tr><th>우편번호</th>
		<td><input type="text" name="memPost" id="sample4_postcode" value="${dto.memberPost }"/></td></tr>
	<tr><th>생년월일</th>
		<td><input type="date" name="memBirth" 
				value='<fmt:formatDate value="${dto.memberBirth }" pattern="yyyy-MM-dd"/>'/></td></tr>
	<tr><th colspan="2"><input type="submit" value="등록">
			<input type="button" value="목록으로" 
				   onclick="javascript:location.href='memberList'" />
		</th></tr>
</table>
</form>
</body>
</html>