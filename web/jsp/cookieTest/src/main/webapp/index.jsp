<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//쿠키 생성
	Cookie cookie = new  Cookie("name" , "이숭무");
	// 저장 위치
	cookie.setPath("/");
	// 생명주기
	cookie.setMaxAge(60*60*24*30);
	// 쿠키는 브라우저에 저장
	response.addCookie(cookie);
	
	Cookie cookie1 = new Cookie("date", URLEncoder.encode(new Date().toString()));
	cookie1.setPath("/");
	cookie1.setMaxAge(60*60*24*30);
	response.addCookie(cookie1);
%>
<% request.setAttribute("memberId", "highland0"); %>
<% session.setAttribute("userId", "highland1"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= request.getAttribute("memberId") %><br />
<% out.print(request.getAttribute("memberId")); %><br />
${memberId}<br />
<%= session.getAttribute("userId") %><br />
${userId }<br />

<%= cookie.getName() %><br />
<%= cookie.getValue() %><br />
<%= cookie1.getName() %><br />
<%= cookie1.getValue() %><br />
<%
	// 원하는 쿠키 찾기
	Cookie [] cookies = request.getCookies(); // 브라우저에 있는 쿠키 모두 불러오기
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie2 : cookies){
			if(cookie2.getName().equals("name")){
				out.print(cookie2.getValue());
			}
		}
	}
	// 쿠키 삭제
	Cookie cookie3 = new Cookie("name",""); 
	cookie3.setMaxAge(0); // 생명주기 0으로 주면 쿠키 삭제
	response.addCookie(cookie3);
%>
<a href="logout.hk">로그아웃</a>
<c:if test="${empty auth }">
<form action="login.hk" method="post">
<table border=1 width=500>
	<tr><td colspan="2">
			<input type="checkbox" name="autoLogin"/> 자동로그인  | 
			<input type="checkbox" value="store" name="storeId" 
				<c:if test="${!empty member }">checked</c:if> /> 아이디저장
		</td></tr>
	<tr><td><input type="text" name="userId" value="${member }"/></td>
		<td rowspan="2">
			<input type="submit" value="로그인"/></td>
	</tr>
	<tr>
		<td><input type="password" name="userPw" /></td>
	</tr>
</table>
</form>
</c:if>
</body>
</html>