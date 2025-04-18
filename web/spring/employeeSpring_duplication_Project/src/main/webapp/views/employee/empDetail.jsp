<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 상세 정보 <br />
직원 번호 : ${employeeCommand.empNum  } <br />
직원 이름 : ${employeeCommand.empName  } <br />
직원 아이디 : ${employeeCommand.empId  } <br />
직원 입사일 : <fmt:formatDate value="${employeeCommand.empHireDate  }" pattern="yyyy-MM-dd"/>
<br />
<a href="empList">직원 목록</a> | 
<a href="empUpdate?empNum=${employeeCommand.empNum  }">직원 수정</a> | 
<a href="empDelete?empNum=${employeeCommand.empNum  }">직원 삭제</a>
</body>
</html>