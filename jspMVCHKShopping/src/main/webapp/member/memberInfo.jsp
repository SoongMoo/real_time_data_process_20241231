<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
</head>
<body>
회원 상세 정보<br />
회원번호 : ${dto.memberNum }<br />
회원이름 : ${dto.memberName }<br />
회원아이디 : ${dto.memberId }<br />
회원 주소 : ${dto.memberAddr }<br />
회원 상세 주소 : ${dto.memberAddrDetail }<br />
회원 우편번호 : ${dto.memberPost }<br />
회원 성별 : ${dto.memberGender }<br />
회원 연락처1 : ${dto.memberPhone1 }<br />
회원 연락처2 : ${dto.memberPhone2 }<br />
회원 등록일 : ${dto.memberRegist }<br />
회원이메일 : ${dto.memberEmail }<br />
회원 생년월일 : ${dto.memberBirth }<br />
<a href="memberList.mem">회원 목록</a>
<a href="memberModify.mem?memberNum=${dto.memberNum }">회원정보수정</a>
<a href="memberDelete.mem?memberNum=${dto.memberNum }">회원삭제</a>
</body>
</html>