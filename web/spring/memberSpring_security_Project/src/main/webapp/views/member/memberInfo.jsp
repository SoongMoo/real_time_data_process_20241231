<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원 정보 상세보기<br />
회원번호: ${dto.memberNum }<br />
회원이름: ${dto.memberName }<br />
회원아이디 : ${dto.memberId }<br />
<a href="memberList">회원목록</a> | 
<a href="memberUpdate?memberNum=${dto.memberNum }">회원수정</a> | 
<a href="memberDelete?memberNum=${dto.memberNum }">회원삭제</a>
</body>
</html>