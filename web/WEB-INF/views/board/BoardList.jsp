<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.budong.R" %>
<%-- <%@ include file="../khw/index.jsp" %>  --%>
<script type="text/javascript">

	function change1(obj){
		obj.style.background = '#58CCBD';
		obj.style.color = 'white';
	}
	
	function change2(obj){
		obj.style.background = 'white';
		obj.style.color = 'black';
	}
</script>

<html>
<head>
	<title>게시판 리스트</title>
</head>
<body>
	<link rel="stylesheet" type="text/css" href="style.css">
<div align="center">
	<br>
	<h2><b>글 목 록</b></h2>
	<br>
	<table width="800" border="1">
		<tr >
			<td align="right">
				<!-- <a href="<%=R.requestToHost(R.mapping.board_writeform)%>">글쓰기</a>  -->
				<input type="button"  value="글쓰기" onmouseout="change2(this)" onmouseover="change1(this)" style="background-color:white;"
						onclick="window.location='boardWrite.do'">
			</td>
		</tr>	
	</table>
	<table border="1" width="800">
		<tr bgcolor="#EAEAEA">
			<th>글번호</th>
			<th width="40%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="6">
					게시된 글이 없습니다.
				</td>
			</tr>	
		</c:if>
		<c:forEach var="dto" items="${list}">
			<tr>
			<td>${dto.num}</td>
				<td><a href="boardContent.do?num=${dto.num}">${dto.title}</a></td>
					<c:if test="${dto.readcnt>10}">
					</c:if>
				</td> 
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.readcnt}</td>
			</tr>	
		</c:forEach>
	</table>
</div>
</body>
</html>