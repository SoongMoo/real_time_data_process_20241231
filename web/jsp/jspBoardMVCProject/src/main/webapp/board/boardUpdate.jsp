<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시글 수정<br />
<form action="boardModify.naver" method="post">
<input type="hidden"  name="boardNum" value="${dto.boardNum }"/>
글쓴이 : <input type="text" name = "boardName" value="${dto.boardName }"/><br />
제목 : <input type="text" name="boardSubject" value="${dto.boardSubject }"/><br />
내용 : <textarea rows="10" cols="30" name="boardContent">${dto.boardContent }</textarea><br />
<input type="submit" value="게시글 수정">
</form>
</body>
</html>