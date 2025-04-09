<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardWrite.nhn" method="post">
<table border="1" width=600>
	<tr><td>글쓴이</td>
		<td><input type="text" name="boardWriter" /></td></tr>
	<tr><td>제목</td>
		<td><input type="text" name="boardSubject" /></td></tr>
	<tr><td>내용</td>
		<td><textarea rows="10" cols="50" name="boardContent"></textarea></td></tr>
	<tr><th colspan="2">
			<input type="submit" value="저장" />
		</th></tr>
</table>
</form>
</body>
</html>