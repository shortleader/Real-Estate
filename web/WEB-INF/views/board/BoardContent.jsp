<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.budong.R" %>
	<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">

	function change1(obj){
		obj.style.background = '#58CCBD';
		obj.style.color = 'white';
	}
	
	function change2(obj){
		obj.style.background = 'white';
		obj.style.color = 'black';
	}
	
 	function checkPwd(pwd,num){
  		var inputPwd =prompt("수정하시려면 비밀번호를 입력하세요"+pwd);
		if(inputPwd==pwd){
			 location.href="boardUpdateForm.do?num="+num;
		}else {
			alert("비밀번호가 틀립니다.");
		}
 	} 
 	
 	function checkPwdDelete(pwd,num){
  		var inputPwd =prompt("삭제하시려면 비밀번호를 입력하세요"+pwd);
		if(inputPwd==pwd){
			 location.href="boardDelete.do?num="+num;
		}else{
			alert("비밀번호가 틀립니다.");
		}
 	} 
 	
</script>

	<div align="center">
		<br>
		<h2><b>글내용 보기</b></h2>
		<br><br>
		
		
		<c:forEach var="dto" items="${content}">
			<table border="1" width="99%">
			<tr>
				<th bgcolor="#A6A6A6" width="20%">글번호</th>
				<td>${dto.num}</td>
				<th bgcolor="#A6A6A6" width="20%">조회수</th>
				<td>${dto.readcnt}</td>
			</tr>
			<tr>
				<th bgcolor="#A6A6A6" width="20%">작성자</th>
				<td>${dto.writer}</td>
				<th bgcolor="#A6A6A6" width="20%">작성일</th>
				<td>${dto.reg_date}</td>
			</tr>
			<tr>
				<th bgcolor="#A6A6A6" width="20%">글제목</th>
				<td colspan="3">${dto.title}</td>
			</tr>
			<tr>
				<th bgcolor="#A6A6A6" width="20%">글내용</th>
				<td colspan="3">${dto.content}</td>
			</tr>
			</table>
			<table>
			<tr>
				<td colspan="4" align="center">
					<input type="button"  value="글수정"  onmouseout="change2(this)" onmouseover="change1(this)" style="background-color:white;"
					onclick="checkPwd('${dto.pwd}','${dto.num}');">
						&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button"  value="글삭제" onmouseout="change2(this)" onmouseover="change1(this)" style="background-color:white;"
						onclick="checkPwdDelete('${dto.pwd}','${dto.num}');">
						&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button"  value="글목록" onmouseout="change2(this)" onmouseover="change1(this)" style="background-color:white;"
					onclick="window.location='boardList.do'">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button"  value="댓글달기" onmouseout="change2(this)" onmouseover="change1(this)" style="background-color:white;"
					onclick="window.location='boardReplyForm.do?num=${dto.num}'">
				</td>
				
			</tr>
			</table>
			</c:forEach>
		
	</div>



