<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<p> <a href= "${pageContext.request.contextPath}/showsemester">학기별 이수 학점 조회  </a>
<p> <a href= "${pageContext.request.contextPath}/showdivision">이수 구분별 학점 조회 </a>
<p> <a href= "${pageContext.request.contextPath}/registercourse">수강 신청  </a>
<p> <a href= "${pageContext.request.contextPath}/showregistercourse">수강 신청 조회 </a>

</body>
</html>
