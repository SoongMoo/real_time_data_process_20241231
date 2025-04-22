<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
[필수]글내용<br />
<form action="userWrite" method="get">
<textarea rows="5" cols="80" readonly="readonly">
규약
</textarea><br />
<input type="checkbox" required="required" />동의<br />
<input type="submit" value="회원가입"/>
</form>
</body>
</html>