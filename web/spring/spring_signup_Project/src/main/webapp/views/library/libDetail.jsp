<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세보기<br />
글번호 :  ${libraryCommand.libNum }<br />
글쓴이 :	${libraryCommand.libWriter }<br />
제목 :	${libraryCommand.libSubject }<br />
내용 : 	${libraryCommand.libContent }<br />
<c:set var="originalFileName" value="${fn:split(libraryCommand.libOriginalName,'`') }"/>

<c:forTokens items="${libraryCommand.libStoreName }" delims="`" var="fileName" varStatus="idx">
 <a href="libDownLoad?oname=${originalFileName[idx.index] }&sname=${fileName }">
 	${originalFileName[idx.index] }
 </a><br />
</c:forTokens>

<img src="/static/libUpload/${libraryCommand.libImageStoreName }" width=300 /><br />

<a href="libUpdate?libNum=${libraryCommand.libNum }">자료실 수정</a> | 
<a href="libDelete?libNum=${libraryCommand.libNum }">자료실 삭제</a> | 
<a href="library">자료실</a>
</body>
</html>





