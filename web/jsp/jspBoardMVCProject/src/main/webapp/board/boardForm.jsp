<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardForm.jsp</title>
</head>
<body>
<form action="boardWrtie.naver" method="post">
	글쓴이 : <input type="text" name="boardName" /><br />
	제목 : <input type="text" name="boardSubject" /><br />
	내용 : <textarea rows="10" cols="30" name="boardContent"></textarea><br />
	<input type="submit" value="전송" >	
</form>
</body>
</html>