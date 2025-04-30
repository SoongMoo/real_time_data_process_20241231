<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
function fileDel(btn, org, store, kind){
	$.ajax({//삭제하려는 파일을 session에 저장 : session에 저장하려면 스프링부트에 갔다와야 하는데 화면은 그대로 있어야 한다.
		type:'post',
		url:'/file/fileDel',
		data:{"orgFile": org,"storeFile":store},
		dataType:'text',
		success: function(result){
			if($(btn).text() == "삭제"){
				$(btn).text("삭제취소");
				if(kind == 'image'){
					$("#imageFile").html("<input type='file' name='libImageFile' />");
					$("#image").text("");
				}
			}else{
				$(btn).text("삭제");
				if(kind == 'image'){
					$("#imageFile").html("");
					$("#image").text(org);
				}
			}
		},
		error:function(){
			alert("서버오류");
		}
	});
	
}
</script>
</head>
<body>
<form:form action="libUpdate" method="post" modelAttribute="libraryCommand"
	enctype="multipart/form-data">
<form:hidden path="libNum"/>
<table border=1 width=600>
	<tr><th>제목</th>
		<td><form:input path="libSubject"/><form:errors path="libSubject" /> </td></tr>
	<tr><th>글쓴이</th>
		<td><form:input path="libWriter"/><form:errors path="libWriter" /></td></tr>
	<tr><th>내용</th>
		<td><form:input path="libContent"/></td></tr>
	<tr><th>파일</th>
		<td>
																<!-- command -->
			<c:set var="originalFileName" value="${fn:split(libraryCommand.libOriginalName,'`') }"/>
			                      <!-- command -->
			<c:forTokens items="${libraryCommand.libStoreName }" delims="`" var="fileName" varStatus="idx">
			  	${originalFileName[idx.index] }
			  	<button type="button" onclick="fileDel(this,'${originalFileName[idx.index] }'
										,'${fileName }')">삭제</button><br />
			</c:forTokens>		
			<input type="file" name="libFile" multiple="multiple"/> 
		</td></tr>
	<tr><th>이미지파일</th>
		<td><c:if test="${empty fn:trim(libraryCommand.libImageOriginalName)}">
				<input type='file' name='libImageFile' /> <!--  추가 -->
			</c:if>
			<c:if test="${!empty fn:trim(libraryCommand.libImageOriginalName)}">
			<span id="imageFile"></span>
			<span id="image">${libraryCommand.libImageOriginalName }</span>
			<button type="button" onclick="fileDel(this,'${libraryCommand.libImageOriginalName }'
					,'${libraryCommand.libImageStoreName }', 'image')">삭제</button></td></tr>
			</c:if>
	<tr><th colspan="2"><input type="submit" value="자료수정완료"/></th></tr>
</table>
</form:form>
</body>
</html>