<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시글 상세보기<br />
번호 : ${dto.boardNum }<br />
글쓴이 : ${dto.boardName }<br />
제목 : ${dto.boardSubject }<br />
내용 : ${dto.boardContent }<br />
<a href="boardList.naver">목록으로가기</a>
<a href="boardModify.naver?boardNum=${dto.boardNum }">수정하기</a>
<a href="boardDelete.naver?boardNum=${dto.boardNum }">삭제하기</a>
</body>
</html>