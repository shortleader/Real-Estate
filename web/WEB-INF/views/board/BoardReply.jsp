<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file ="../board/BoardContent.jsp" %>
<link rel="stylesheet" type="text/css" href="style.css">
<head>
<title>댓글 달기</title>
</head>

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

<div align="center">
	<br>
	<br>
	<br>
	<br>
		<table border="1" width="99%">
			<tr>
				<th width="20%">댓글</th>
				<td><textarea style="width:100%;border:1;overflow:visible;text-overflow:ellipsis;resize: none;" width="99%" name="content" rows="8" cols="50"></textarea>
				</td>
			</tr>
		</table>
		<table  width="99%">
		<tr align="right">
		<td >
		<input type="button" value="댓글 등록" onmouseout="change2(this)" onmouseover="change1(this)" style="background-color:white;"
					onclick="window.location='boardReply.do'"
					> &nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					</tr>
		</table>
</div>








