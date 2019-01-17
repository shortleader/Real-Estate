<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setStatus(200);
	String badURI = request.getRequestURI();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 ERROR PAGE !</title>
</head>
<body>
	<div align="center">
		<h2>404 ERROR !!!</h2>
		<h4><%=badURI %>는 <br>존재하지 않거나 </h4>
		<img src="<%=request.getContextPath() %>/resources/images/error-404.png" />
			
		<%@ include file="bottom.jsp" %>
	</div>
</body>
</html>