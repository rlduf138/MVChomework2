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
		actions="${pageContext.request.contextPath}/docreate"
		modelAttribute="courses">
		<table border="1">
			<tr>
				<td>수강년도</td>
				<td>학기</td>
				<td>수강코드</td>
				<td>과목명</td>
				<td>구분</td>
				<td>학점</td>
			</tr>
			<c:forTokens var="courses" delims = "#" items="${courses}">
			<tr>
			<c:forTokens var="courses" delims = "," items="${courses}">
				<td>${courses}</td>
			</c:forTokens>
			</c:forTokens>

		</table>


	</sf:form>


</body>
</html>