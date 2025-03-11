<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width=300>
	<tr><td>이름</td><td>주소</td><td>전화</td></tr>
	<% for(int i = 0 ; i < 10 ; i++){ 
		out.print("<tr><td>1</td><td>2</td><td>3</td></tr>");
	 } 
	 %>
	 <% for(int i = 0 ; i < 10 ; i++){ %> <!-- 스크립트릿 -->
		<tr><td>1</td><td>2</td><td>3</td></tr>
	 <%}%>
	 <% for(int i = 0 ; i < 10 ; i++){ %>
	 <%= "<tr><td>1</td><td>2</td><td>3</td></tr>" %><!-- 표현식 -->
	 <%}%>
</table>
</body>
</html>