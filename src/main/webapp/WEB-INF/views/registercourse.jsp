<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
href = "${pageContext.request.contextPath}/resources/css/main.css">

<title>Insert title here</title>
</head>
<body>

<h1>2017년도 1학기 수강신청</h1>
<sf:form method = "get" action="${pageContext.request.contextPath}/docreate" modelAttribute="course">
	<table class = "formtable">
	<tr>
	<td class = "label">수강코드</td>
	<td><sf:input class="control" path="code" type="text" /><br/>
		<sf:errors cssClass = "error" path="code"></sf:errors>
	</td>
	</tr>
	<tr>
	<td class = "label">과목이름</td>
	<td><sf:input class="control" path="name" type="text" /><br/>
		<sf:errors cssClass = "error" path="name"></sf:errors>
	</td>
	</tr>
	<tr>
	<td class = "label">구분</td>
	<td><sf:input class="control" path="division" type="text" /><br/>
		<sf:errors cssClass = "error" path="division"></sf:errors>
	</td>
	</tr>
	<tr>
	<td class = "label">학점</td>
	<td><sf:input class="control" path="credit" type="text" /><br/>
		<sf:errors cssClass = "error" path="credit"></sf:errors>
	</td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value = "신청"></td>
	</tr>
	</table>
</sf:form>
</body>
</html>