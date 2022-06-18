<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정 페이지</title>
    <link rel="stylesheet"  type="text/css"  href="#">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- 부트 스트랩 링크 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <!-- 글꼴 링크 -->
	<link rel="stylesheet"  type="text/css"  href="../h_main/css/main.css">
	<!-- 헤더 css 추가 -->
<script type="text/javascript">

function validateForm(form) {
	if(form.name.value ==""){
		alert("이름을 입력해주세요.");
		form.name.focus();
		return false;
	}
	if(form.title.value ==""){
		alert("제목을 입력해주세요.");
		form.title.focus();
		return false;
	}
	if(form.content.value ==""){
		alert("내용을 입력해주세요.");
		form.content.focus();
		return false;
	}
}
function checkSize(input) {
	if (input.files && input.files[0].size > (1024000)) {
		alert("파일 사이즈가 1mb 를 넘습니다.");
		input.value = null;
	    }
}
</script>
</head>

<body>
<%@ include file ="../h_main/header.jsp" %>
<center>
	<br><br>	
	<h2> 게시물 수정 페이지 (작성자명 수정 가능) </h2>
	<br><br>
</center>
<!--  폼에서 파일을 업로드 할때 
		1.method가 반드시 post
		2.enctype="multipart/form-data"  
			form의 모든 변수는 request 객체가 아니라 라이브러리에서 지정한 메소드에서 변수의 값을 받는다. 
		-->
<form name="writeFrm" method="post" enctype="multipart/form-data" 
		action="../h_board/edit.do" onsubmit="return validateFrom(this);">
<input type="hidden" name="idx" value="${dto.idx }"/>
<input type="hidden" name="prevOfile" value="${dto.ofile }"/>
<input type="hidden" name="prevSfile" value="${dto.sfile }"/>
<table border="2" width="90%" class ="table">
	<tr>
		<td>작성자</td>
		<td>
			<%if(session.getAttribute("id") != null) { %>
			<input type="text" name="name" style="width:150px;" value ="<%=session.getAttribute("id")%>" />
			<%}else{ %>
			<input type="text" name="name" style="width:150px;" />
			<%} %>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="title" style="width:90%;"/>
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="content" style="width:90%; height:200px;"></textarea>
		</td>
	</tr>
	<tr>
		<td>첨부 파일</td>
		<td>
			<input type="file" name="ofile" onchange="checkSize(this)"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit" class="btn btn-primary"> 작성 완료 </button> &nbsp;&nbsp;
			<button type="reset" class="btn btn-warning"> RESET </button>	&nbsp;&nbsp;
			<button type="button"  class="btn btn-success" onclick="location.href='../h_board/list.do';">
				목록 바로가기
			</button>
		</td>
	</tr>
	
</table>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 부트 스트랩 소스 -->
</body>
</html>