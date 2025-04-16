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
직원 정보<br />
<table border=1 width=600> 
	<tr><th width="200">직원번호</th>
		<td>${employeeCommand.empNum }</td></tr>
	<tr><th>직원아이디</th>
		<td>${employeeCommand.empId }</td></tr>
	<tr><th>직원이름</th>
		<td>${employeeCommand.empName }</td></tr>
	<tr><th>직원입사일</th>
		<td><fmt:formatDate value="${employeeCommand.empHireDate }" 
							pattern="yyyy-MM-dd"/> </td></tr>
	<tr><th colspan="2"><button type="button" 
				onclick="javascript:location.href='empList'">직원목록</button>
			<button type="button" 
				onclick="javascript:location.href='empUpdate?empNum=${employeeCommand.empNum }'">직원수정</button>
			<button type="button" 
				onclick="javascript:location.href='empDelete?empNum=${employeeCommand.empNum }'">직원삭제</button>
		</th></tr>
</table>
</body>
</html>