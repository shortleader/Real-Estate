<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.budong.R"%>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function change1(obj) {
		obj.style.background = '#58CCBD';
		obj.style.color = 'white';
	}

	function change2(obj) {
		obj.style.background = 'white';
		obj.style.color = 'black';
	}

	function update() {
		f.submit();
	}
</script>
<div align="center">
<c:forEach var="dto" items="${content}">
<form name="f" method="post" action="boardUpdate.do?num=${dto.num}">
	<table border="1" width="99%">
		<br>
		<h2><b>글 수 정</b></h2>
		<br><br>
		<tr>
			<th width="20%" bgcolor="#A6A6A6">이 름</th>
			<td><input type="text" name="writer" value="${dto.writer}"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="#A6A6A6">제 목</th>
			<td><input type="text" name="title" value="${dto.title}"></td>
		</tr>
		<tr>
			<th width="20%" bgcolor="#A6A6A6">내 용</th>
			<td><textarea style="width:100%;border:1;overflow:visible;text-overflow:ellipsis;resize: none;"
			 width="99%" name="content" rows="8" cols="50">${dto.content}</textarea></td>
		</tr>
</table>
<table width="99%">	
			<tr align="center">
				<td colspan="2"><input type="button" value="글수정" name="btnupdate"
					onmouseout="change2(this)" onmouseover="change1(this)"
					style="background-color: white;"
					onclick="update()">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="다시작성"
					onmouseout="change2(this)" onmouseover="change1(this)"
					style="background-color: white;"> &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="목록보기"
					onmouseout="change2(this)" onmouseover="change1(this)"
					style="background-color: white;"
					onclick="window.location='boardList.do'"></td>
			</tr>
		
	</table>
	</form>
	</c:forEach>
</div>
