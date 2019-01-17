<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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