<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function checkBoard(){
		if (f.writer.value==""){
			alert("이름을 입력하세요")
			f.writer.focus()
			return false;
		}
		if (f.subject.value==""){
			alert("제목을 입력하세요")
			f.subject.focus()
			return false;
		}
		if (f.content.value==""){
			alert("내용을 입력하세요")
			f.content.focus()
			return false;
		}
		if (f.passwd.value==""){
			alert("비밀번호를 입력하세요")
			f.passwd.focus()
			return false;
		}
		
	}
		
		function change1(obj) {
			obj.style.background = '#58CCBD';
			obj.style.color = 'white';
		}

		function change2(obj) {
			obj.style.background = 'white';
			obj.style.color = 'black';
		}

				
</script>
<div align="center">
	<form name="f" action="boardInsert.do" method="post"
				onsubmit="return checkBoard()">
		<table border="1" width="99%">
			<br>
		<h2><b>글 쓰 기</b></h2>
		<br><br>
			<tr >
				<th width="20%" bgcolor="#A6A6A6">이 름</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="#A6A6A6">제 목</th>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<th width="20%" bgcolor="#A6A6A6">내 용</th>
				<td><textarea style="width:100%;border:1;overflow:visible;text-overflow:ellipsis;resize: none;"
			 width="99%" name="content" rows="8" cols="50"></textarea></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="#A6A6A6">비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			</table>
			<table>
			<tr align="center" >
				<td >
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성" onmouseout="change2(this)" onmouseover="change1(this)"
					style="background-color: white;">
					<input type="button" value="목록보기" 
					onmouseout="change2(this)" onmouseover="change1(this)"
					style="background-color: white;"
					onclick="window.location='boardList.do'">
				</td>
			</tr>
		</table>
	</form>
</div>
