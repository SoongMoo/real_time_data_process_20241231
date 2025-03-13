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
<form action="memberModify.mem" method="post">
회원등록 페이지입니다.<br />
회원번호 : <input type="text" name="memberNum" readonly="readonly" value="${dto.memberNum }" /><br />
회원이름 : <input type="text" name="memberName" value="${dto.memberName }"/><br />
회원아이디 : <input type="text" name="memberId" value="${dto.memberId }"/><br />
회원 주소 : <input type="text" name="memberAddr" value="${dto.memberAddr }"><br />
회원 상세주소 : <input type="text" name="memberAddrDetail" value="${dto.memberAddrDetail }"/><br />
우편번호 :  <input type="text" name="memberPost" value="${dto.memberPost }"/><br />
회원연락처1 :  <input type="tel" name="memberPhone1" value="${dto.memberPhone1 }"/><br />
회원연락처2: <input type="tel" name="memberPhone2" value="${dto.memberPhone2 }"/><br />
회원 성별 : <input type="radio" name="memberGender" value="M" 
			<c:if test="${dto.memberGender == 'M' }">checked</c:if> />남자
          <input type="radio" name="memberGender" value="F" 
          	<c:if test="${dto.memberGender == 'F' }">checked</c:if> />여자<br />
회원이메일 :  <input type="email" name="memberEmail" value="${dto.memberEmail }"><br />
회원생년월일 :  <input type="date" name="memberBirth" value="${dto.memberBirth }"><br />
<input type="submit" value="회원수정하기"/>
</form>
</body>
</html>