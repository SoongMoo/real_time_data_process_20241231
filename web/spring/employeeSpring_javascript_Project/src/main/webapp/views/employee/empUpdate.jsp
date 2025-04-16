<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		}
		if($("#empHireDate").val() == ""){
			alert("입사일을 입력하세요.");
			$("#empHireDate").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
직원 정보 수정<br />
<form action="empUpdate" method="post" id="frm">
<table border=1 width=600> 
	<tr><th width="200">직원번호</th>
		<td><input type="text" id="empNum" value="${employeeCommand.empNum }" name="empNum"/></td></tr>
	<tr><th>직원아이디</th>
		<td><input type="text" id="empId" value="${employeeCommand.empId }" name="empId" /></td></tr>
	<tr><th>직원이름</th>
		<td><input type="text" id="empName" value="${employeeCommand.empName }" name="empName" /></td></tr>
	<tr><th>직원비밀번호</th>
		<td><input type="password" id="empPw"  name="empPw"/>
			<span style="color:red">${errPw }</span>
			</td></tr>
	<tr><th>직원입사일</th>
		<td><input type="date" id="empHireDate" value='<fmt:formatDate value="${employeeCommand.empHireDate }" 
							pattern="yyyy-MM-dd"/>' name="empHireDate"/> </td></tr>
	<tr><th colspan="2"><button type="button" 
				onclick="javascript:location.href='empList'">직원목록</button>
			<button type="submit">직원수정</button>
		</th></tr>
</table>
</form>
</body>
</html>