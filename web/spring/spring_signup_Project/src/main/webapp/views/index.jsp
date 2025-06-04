<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
$(function(){
	page = 1;
	$("#load-more").click(function(){
		page ++;
		$.ajax({
			url:"loadMore",
			type:"post",
			data : {"page": page},
			dataType : "json",
			success:function(model){
				console.log(model);
				var item="";
				item += '<table align="center" width="900">';
				item += '	<tr>';
				$.each( model.list, function(idx ,dto){
					item += '		<td><a href="libInfo?libNum='+dto.libNum+'">';
					item += '			<img src="/static/libUpload/'+dto.libImageStoreName +'" width=300/>';
					item += '				'+dto.libSubject +'<br/>';
					item += '				'+dto.libWriter +'<br />';
					item += '			</a>';
					item += '		</td>';
					if((idx + 1) % 3 == 0 )  item += "</tr><tr>";
				});
				item += '	</tr>';
				item += '</table>';
				$("#content").append(item);
				if(model.maxPage <= page ) $("#more").css("display","none")
			},
		});
	});
});
</script>
</head>
<body>
안녕하세요<br /><a href="/mailling">메일링</a> | <a href="/library">자료실</a> | <a href="/realStock">실시간데이터</a>
<c:if test="${!empty auth }">
<a href="/login/logout">로그아웃</a>
</c:if>
<c:if test="${empty auth }">
<form:form modelAttribute="loginCommand" action="/login/login" method="post">
<table border=1 >
	<tr><td colspan="2">
			자동로그인 <input type="checkbox" name="autoLogin" /> | 
			아이디저장 <input type="checkbox" name="idStore"
				<c:if test="${loginCommand.idStore }">checked</c:if> />
		</td></tr>
	<tr><td><form:input path="userId"/><form:errors path="userId"/></td>
		<td rowspan="2"><input type="submit"  value="로그인"/></td></tr>
	<tr><td><form:password path="userPw" /><form:errors path="userPw" /></td></tr>
	<tr><td colspan="2">
		<a href="/help/findId">아이디</a>/<a href="/help/findPassword">비밀번호</a>찾기	| 
		<a href="/register/userAgree">회원가입</a>
		</td></tr>
</table>
</form:form>
</c:if>
<div id="content">
<table align="center" width="900">
	<tr>
		<c:forEach items="${list }" var="dto" varStatus="idx">
		<td><a href="libInfo?libNum=${dto.libNum }">
				<img src="/static/libUpload/${dto.libImageStoreName }" width=300/>
				${dto.libSubject }<br/>
				${dto.libWriter }<br />
			</a>
		</td>
		<c:if test="${idx.count % 3 == 0 }"></tr><tr></c:if>
		</c:forEach>
	</tr>
</table>

</div>
<div id="more">
<table align = "center" width="900" >
	<tr><th><button id="load-more">더보기</button></th></tr>
</table>
</div>
</body>

</html>




