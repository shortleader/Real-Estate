<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	response.setStatus(200);
	String badURI = request.getRequestURI();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>404 ERROR PAGE !</title>
</head>
<body>
	<div align="center">
		<h2>404 ERROR !!!</h2>
		<h4><%=badURI %>는 <br>잘못된  접근이거나 존재하지  않는  페이지  입니다.</h4>
		<img src="<%=request.getContextPath() %>/resources/images/error-404.png" />
			
		<%@ include file="bottom.jsp" %>
	</div>
</body>
</html>