<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
</head>
<body>
<form action="memberWrite.mem" method="post">
회원등록 페이지입니다.<br />
회원번호 : <input type="text" name="memberNum" readonly="readonly" value="${memberNum }" /><br />
회원이름 : <input type="text" name="memberName"/><br />
회원아이디 : <input type="text" name="memberId"/><br />
회원비밀번호 : <input type="password"  name="memberPw"/><br />
회원비밀번호 확인 : <input type="password" name="memberPwCon"> <br />
회원 주소 : <input type="text" name="memberAddr"><br />
회원 상세주소 : <input type="text" name="memberAddrDetail" /><br />
우편번호 :  <input type="text" name="memberPost"/><br />
회원연락처1 :  <input type="tel" name="memberPhone1"/><br />
회원연락처2: <input type="tel" name="memberPhone2"/><br />
회원 성별 : <input type="radio" name="memberGender" value="M" checked="checked" />남자
          <input type="radio" name="memberGender" value="F" />여자<br />
회원이메일 :  <input type="email" name="memberEmail" ><br />
회원생년월일 :  <input type="date" name="memberBirth" ><br />
<input type="submit" value="회원등록하기"/>
</form>
</body>
</html>