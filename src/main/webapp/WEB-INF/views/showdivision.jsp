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
		modelAttribute="divisions">
		<table border="1">
			
			<c:forTokens var="divisions" delims = "#" items="${divisions}">
			<tr>
			<c:forTokens var="divisions" delims = "," items="${divisions}">
				<td>${divisions}</td>
			</c:forTokens>
			<tr>
			</c:forTokens>

		</table>


	</sf:form>


</body>
</html>