<%@ page import="com.budong.R"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/icon/main.ico">
<title>여기 부동산 어떄</title>

<!-- Bootstrap core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="resources/css/4-col-portfolio.css" rel="stylesheet">


</head>
<body>
	
	<c:import url="loading.jsp"></c:import>	
	<c:import url="../top.jsp"></c:import>

	<c:forEach var="dto" items="${list}">

		<table>
			<tr>
				<td>${dto.phone}</td>
				<td>${dto.dong}</td>
			</tr>
		</table>

	</c:forEach>

	<c:import url="../bottom.jsp"></c:import>
	
</body>

</html>