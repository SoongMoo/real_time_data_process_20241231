<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardModify" method="post">
<input type="hidden" name="boardNum" value="${dto.boardNum }" />
<table border=1 width=600>
	<tr><td>글쓴이</td>
		<td><input type="text" name="boardWriter" value="${dto.boardWriter }"/></td></tr>
	<tr><td>제목</td>
		<td><input type="text" name="boardSubject" value="${dto.boardSubject }"/></td></tr>
	<tr><td>내용</td>
		<td><textarea rows="10" cols="80" name="boardContent">${dto.boardContent }</textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="수정"/></td></tr>
</table>
</form>
</body>
</html>