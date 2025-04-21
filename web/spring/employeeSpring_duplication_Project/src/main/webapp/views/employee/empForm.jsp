<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#empId").on("change keyup", function(){ // 아이디 중복확인
		// @RestAPI <====> ajax : csr
		$.ajax({
			type : "post",
			url : "../duplication/idCheck",
			data : {"userId" : $(this).val()},
			dataType: "text",
			success:function(result){ // result == id
				if(!result.trim()){ // "":false , null은 ""로 처리된다.
					$("#idCheck").text("사용가능한 아이디입니다.");
					$("#idCheck").css("color","blue");
				}else{
					$("#idCheck").text("사용중인 아이디입니다.");	
					$("#idCheck").css("color","red");
				}
			},
			errors:function(){
				alert("서버오류");
			}
		});
	});
	
	$("#empEmail").on("change keyup", function(){
		$.ajax({
			type:"post",
			url : "../duplication/emailCheck",
			data:{"userEmail" : $(this).val()},
			dataType:"text",
			success:function(result){
				if(!result.trim()){ // "":false , null은 ""로 처리된다.
					$("#emailCheck").text("사용가능한 이메일입니다.");
					$("#emailCheck").css("color","blue");
				}else{
					$("#emailCheck").text("사용중인 이메일입니다.");	
					$("#emailCheck").css("color","red");
				}
			},
			errors:function(){
				alert("서버오류");
			}
		});
	});
});
</script>
</head>
<body>
<form:form action="empWrite" method="post" modelAttribute="employeeCommand">
<table border="1" width=600>
	<tr><td>번호</td>
		<td><form:input path="empNum" /></td></tr>
	<tr><td>이름</td>
		<td><form:input path="empName"/> 
			<form:errors path="empName"/></td></tr>
	<tr><td>아이디</td>
		<td><form:input path="empId" />
			<form:errors path="empId"/>
			<span id="idCheck"></span></td></tr>
	<tr><td>비밀번호</td>
		<td><form:password path="empPw"/> 
			<form:errors path="empPw"/></td></tr>
	<tr><td>비밀번호확인</td>
		<td><form:password path="empPwCon" /> 
			<form:errors path="empPwCon"/></td></tr>
	<tr><td>이메일</td>
		<td><form:input path="empEmail" />
			<form:errors path="empEmail"/>
			<span id="emailCheck"></span></td>
	</tr>
	<tr><td>입사일</td>
		<td><input type="date" name="empHireDate" > 
			<form:errors path="empHireDate"/></td></tr>
	<tr><th colspan="2"><input type="submit" value="등록"/></th></tr>
</table>
</form:form>
</body>
</html>