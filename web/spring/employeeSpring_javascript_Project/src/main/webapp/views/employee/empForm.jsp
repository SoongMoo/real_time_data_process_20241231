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
		if($("#empName").val() == ""){
			alert("이름을 입력하세요.");
			$("#empName").focus();
			return false;
		}
		if($("#empId").val() == ""){
			alert("아이디를 입력하세요.");
			$("#empId").focus();
			return false;
		}
		if($("#empPw").val() == ""){
			alert("비밀번호를 입력하세요.");
			$("#empPw").focus();
			return false;
		}else{
			if($("#empPw").val() != $("#empPwCon").val()){
				alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
				$("#empPw").focus();
				$("#empPw").val("");
				$("#empPwCon").val("");
				return false;
			}
		}
		if($("#empHireDate").val() == ""){
			alert("입사일을 입력하세요.");
			$("#empHireDate").focus();
			return false;
		}
	});
	// 유효성 검사 : validation : 검증, 확인
});
</script>
</head>
<body>
직원등록<br />
<form action="empWrite" id="frm" method="post" >
<table border="1" width=600>
	<tr><td>번호</td>
		<td><input type="text" name="empNum" id="empNum" value="${empNum }" />자동부여</td></tr>
	<tr><td>이름</td>
		<td><input type="text" name="empName" id="empName"/></td></tr>
	<tr><td>아이디</td>
		<td><input type="text" name="empId" id="empId"/></td></tr>
	<tr><td>비밀번호</td>
		<td><input type="text" name="empPw" id="empPw"/></td></tr>
	<tr><td>비밀번호확인</td>
		<td><input type="text" name="empPwCon" id="empPwCon"/></td></tr>
	<tr><td>입사일</td>
		<td><input type="date" name="empHireDate" id="empHireDate"/></td></tr>
	<tr><th colspan="2"><input type="submit" value="등록"/></th></tr>
</table>
</form>
</body>
</html>