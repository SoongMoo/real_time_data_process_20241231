<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 정보 수정<br />
<form:form action="empUpdate" method="post" modelAttribute="employeeCommand">
<table border="1" width=600>
	<tr><td>번호</td>
		<td><form:input path="empNum" /></td></tr>
	<tr><td>이름</td>
		<td><form:input path="empName"/> 
			<form:errors path="empName"/></td></tr>
	<tr><td>아이디</td>
		<td><form:input path="empId" />
			<form:errors path="empId"/></td></tr>
	<tr><td>비밀번호</td>
		<td><form:password path="empPw"/> 
			<form:errors path="empPw"/></td></tr>
	<tr><td>입사일</td>
		<td><input type="date" name="empHireDate" 
				value='<fmt:formatDate value="${employeeCommand.empHireDate }" pattern="yyyy-MM-dd"/>'> 
			<form:errors path="empHireDate"/></td></tr>
	<tr><th colspan="2"><input type="submit" value="등록"/></th></tr>
</table>
</form:form>
</body>
</html>