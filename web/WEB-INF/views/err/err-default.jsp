<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
	<div align="center">
		<h2>SOMTHING ERROR !!!</h2>
		<img src="<%=request.getContextPath() %>/resources/images/error-icon-3.png" />
		<br>
		<p>message : ${exception.getMessage() }</p>	
		<%@ include file="bottom.jsp" %>
	</div>
</body>
</html>