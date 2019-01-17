<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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