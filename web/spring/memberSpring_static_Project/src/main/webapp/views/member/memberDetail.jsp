<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세보기<br />
회원번호: ${dto.memberNum }<br />
회원이름: ${dto.memberName }<br />
회원아이디: ${dto.memberId }<br />
회원 주소 : ${dto.memberAddr }<br />
회원 상세주소 : ${dto.memberAddrDetail }<br />
회원 우편번호 : ${dto.memberPost }<br />
회원 생년월일 : <fmt:formatDate value="${dto.memberBirth }" pattern="yyyy-MM-dd"/><br />
<a href="memberList">회원목록</a> | 
<a href="memberUpdate?memberNum=${dto.memberNum }">회원수정</a> | 
<a href="memberDelete?memberNum=${dto.memberNum }">회원삭제</a>
</body>
</html>