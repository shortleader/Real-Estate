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
		return true;
	}
</script>
<div align="center">
	<form name="f" action="boardInsert.do" method="post"
				onsubmit="return checkBoard()">
		<table border="1" width="99%">
			<tr bgcolor="#58CCBD">
				<th colspan="2">글 쓰 기</th>
			</tr>
			<tr >
				<th width="20%">이 름</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th width="20%">제 목</th>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<th width="20%">내 용</th>
				<td><textarea name="content" rows="8" cols="50"></textarea></td>
			</tr>
			<tr>
				<th width="20%">비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr bgcolor="#58CCBD">
				<td colspan="2">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="window.location='boardList.do'">
				</td>
			</tr>
		</table>
	</form>
</div>








