<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500 ERROR</title>
</head>
<body>
	<div align="center">
		<h2 style="font-style: oblique; font-weight: bold; color: red;">!!! 500 ERROR !!!</h2>
		<img src="<%=request.getContextPath() %>/resources/images/error-500.png" />
		
		<%@ include file="bottom.jsp" %>
	</div>
</body>
</html>