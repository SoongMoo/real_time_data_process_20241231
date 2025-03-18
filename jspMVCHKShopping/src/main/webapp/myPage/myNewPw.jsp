<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#frm").submit(function(){
		if($("#newPw").val() != $("#newPwCon").val()){
			alert("비밀번호 확인이 일치하지 않습니다.");
			$("#newPw").val("");
			$("#newPwCon").val("");
			$("#newPw").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
회원 비밀번호 변경
<ul>
	<li><a href='<c:url value="/" />'>홈</a></li>
	<li><a href='memberMyPage.my'>내정보 보기</a></li>
	<li><a href='memberUpdate.my'>내정보 수정</a></li>
	<li><a href="memberPwUpdate.my">비밀번호 변경</a></li>
	<li>회원 탈퇴</li>
</ul>
<form action="memberPwPro.my" method="post" id="frm">
현재비밀번호:<input type="password" name="oldPw" id="oldPw" required="required" />
			<span style="color:red">${pwErr }</span><br />
새 비밀번호:<input type="password" name="newPw" id="newPw" required="required" /><br />
새 비밀번호 확인:<input type="password" name="newPwCon" id="newPwCon" required="required" /><br />
<input type="submit" value="비밀번호 변경" />
</form>
</body>
</html>