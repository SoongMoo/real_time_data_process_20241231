<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
자료실 등록<br />
<form:form action="libWrite" method="post" modelAttribute="libraryCommand" 
	enctype="multipart/form-data" >
<table border=1 width=600>
	<tr><th>제목</th>
		<td><form:input path="libSubject"/><form:errors path="libSubject" /> </td></tr>
	<tr><th>글쓴이</th>
		<td><form:input path="libWriter"/><form:errors path="libWriter" /></td></tr>
	<tr><th>내용</th>
		<td><form:input path="libContent"/></td></tr>
	<tr><th>파일</th>
		<td><input type="file" name="libFile" multiple="multiple"/> </td></tr>
	<tr><th>이미지파일</th>
		<td><input type="file" name="libImageFile"/> </td></tr>
	<tr><th colspan="2"><input type="submit" value="자료등록완료"/></th></tr>
</table>
</form:form>
</body>
</html>