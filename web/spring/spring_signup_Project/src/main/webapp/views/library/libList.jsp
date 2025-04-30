<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/static/js/checkBox.js"></script>
</head>
<body>
자료실 : 검색자료 갯수 : ${count }<br />
<form  action="library" method="get" > 
	<tr><td colspan="5">검색 : 
		<input type="search" name="searchWord" size="60" value="${searchWord}"/>
		<input type="submit" value="검색" />
		</td></tr>
</form>

<form action="libDelete" method="post" >
<a href="libWrite">자료등록</a> <input type="submit" value="선택삭제" />
<table border=1 width=600>
	<tr><th><input type="checkbox" id="checkBoxs" /></th>
		<th>번호</th><th>글쓴이</th><th>제목</th><th>등록일</th></tr>
	<c:forEach items="${list }" var="dto" varStatus="idx">
	<tr><th><input type="checkbox"  name="nums" value="${dto.libNum }"/></th>
		<th>${dto.libNum }</th>
		<th><a href="libInfo?libNum=${dto.libNum }">${dto.libWriter }</a></th>
		<th><a href="libInfo?libNum=${dto.libNum }">${dto.libSubject }</a></th>
		<th>등록일</th></tr>
	</c:forEach>
	<tr><th colspan="5">
			<c:if test="${page <= 1 }">
				[이전]
			</c:if>
			<c:if test="${page > 1 }">
				<a href="library?page=${page-1}">[이전]</a>
			</c:if>
			<c:forEach begin="${startPageNum }" end="${endPageNum }" var="i">
			<a href="library?page=${i }">[${i }]</a>
			</c:forEach>
			<c:if test="${page < maxPage }">
				<a href="library?page=${page+1}">[다음]</a>
			</c:if>
			<c:if test="${page >= maxPage }">
				[다음]
			</c:if>
		</th></tr>
</table>
</form>
</body>
</html>



