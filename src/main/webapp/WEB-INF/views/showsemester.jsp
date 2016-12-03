<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="get"
		actions="${pageContext.request.contextPath}/showSemesterSelected"
		modelAttribute="semesters">
		<table border="1">
			<tr>
				<td>수강년도</td>
				<td>학기</td>
				<td>학점</td>
				<td>링크</td>
			</tr>
			
			
			<c:forTokens var="semesters" delims = "#" items="${semesters}" varStatus = "status">
			<tr>
			<c:forTokens var="semesters" delims = "," items="${semesters}">
				<td>${semesters}</td>
			</c:forTokens>
			
			<td><a href="${pageContext.request.contextPath}/showSemesterSelected?select=${status.index}">링크</a></td>
			
			</tr>
			</c:forTokens>

		</table>


	</sf:form>

</body>
</html>