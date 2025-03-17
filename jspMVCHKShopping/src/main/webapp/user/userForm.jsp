<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userForm.jsp</title>
<!-- CDN -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src ="js/daumAddressScript.js"></script>
<script src="https://code.jquery.com/jquery-1.8.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#frm").submit(function(){
		if( $("#userPw").val() != $("#userPwCon").val() ){
			alert("비밀번호와 비밀번호확인이 다릅니다.");
			$("#userPw").val("");
			$("#userPwCon").val("");
			$("#userPw").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
<form action="userWrite.nhn" method="post" id="frm" >
<table border="1" width="500">
	<tr><td>*아이디</td>
		<td><input type="text" name="userId" required="required"/>아이디 중복 확인</td></tr>	
	<tr><td>*비밀번호</td>
		<td><input type="password" name="userPw" id="userPw" required="required"/></td></tr>
	<tr><td>*비밀번호확인</td>
		<td><input type="password" name="userPwCon" id="userPwCon" required="required"/></td></tr>
	
	<tr><td colspan="2">회원기본정보</td></tr>
	
	<tr><td>*회원이름</td>
		<td><input type="text" name="userName" required="required"/></td></tr>
	<tr><td>*회원 연락처1</td>
		<td><input type="text" name="userPhone1" required="required"/></td></tr>
	<tr><td>회원 연락처2</td>
		<td><input type="text" name="userPhone2" required="required"/></td></tr>
	<tr><td>회원주소</td>
		<td><input type="text" name="userAddr"id="sample4_roadAddress" required="required" readonly="readonly"/>
			<input type="button" value="주소검색" onclick="execDaumPostcode();"/></td></tr>
	<tr><td>회원상세주소</td>
		<td><input type="text" name="userAddrDetail" required="required"/></td></tr>
	<tr><td>회원우편번호</td>
		<td><input type="text" name="userPost" id="sample4_postcode" required="required" readonly="readonly"/></td></tr>
	<tr><td>회원이메일</td>
		<td><input type="email" name="userEamil" required="required"/></td></tr>
	<tr><td>회원생년월일</td>
		<td><input type="date" name="userBirth" required="required"/></td></tr>
	<tr><td>성별</td>
		<td><input type="checkbox" name="userGender" value="M" checked="checked"/>남자
			<input type="checkbox" name="userGender" value="F"/>여자</td></tr>
	<tr><td colspan="2">
			<input type="submit" value="가입하기" />
			<input type="reset" value="다시쓰기" />
			<input type="button" value="가입취소" 
					onclick="javascript:location.href='/jspMVCHKShopping'"/>
		</td></tr>	
</table>
</form>
</body>
</html>


