<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.board.cont.WriteController" %>
  <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 & 질문 글쓰기 </title>
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
	if(form.pass.value ==""){
		alert("비밀번호를 입력해주세요.");
		form.pass.focus();
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
<!-- footer Include -->
<%@ include file ="../h_main/header.jsp" %>

<!-- 상단 우측에 세션 id값 받아오기 : id값이 null이면 로그인 상태가 아니라고 표시 /
							  id값이 null이 아니면 정보 메세지 표시  -->
<div style = "text-align:right; margin-right:100px;">
<br>
	<%
	 String id =  (String) session.getAttribute("id");
	
	 if (id == null) {
	%>
		로그인 상태가 아닙니다 ! <br>
	<% 
	 } else {
	%>
		글 수정을 통해 다른 이름으로 <br> 작성하실 수 있습니다 !
	<%
	 }
	%>
	</div>


<center>
	<br><br>	
	<h2> 리뷰 / 질문 글쓰기 (파일 첨부 가능) </h2>
	<br><br>
</center>

<!-- Form 태그 내에서 input type ="file" 이 존재하면 반드시 
	method="post"
	enctype = "multipart/form-data"  <== 라이브러리를 통해서 업로드 지원
	
	<주의> 	:request.getParameter("name") : request 객체를 사용하면 안됨.
			:라이브러리에서 지원해주는 개체의 메소드로 Form의 변수값을 받아야 한다.
				참고:라이브러리 마다 메소드이름이 다를수 있다.

-->


<form name="writeFrm" method="post" enctype="multipart/form-data" 
		action="../h_board/write.do" onsubmit="return validateFrom(this);">
		
<table border="1" width="90%" class = "table table-bordered">
	<tr>
		<td>작성자</td>
		<td>
		<!-- 세션으로 받아온 id 값이 있으면 id가 수정불가능한 상태로 자동으로 불러옴 -->
			<%if(session.getAttribute("id") != null) { %>
			<input type="text" name="name" style="width:150px;" value ="<%=session.getAttribute("id")%>" readonly/>
		<!--  id값이 없으면 작성이 가능한 입력창을 불려옴 -->
			<%}else{ %>
			<input type="text" name="name" style="width:150px;"/>
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
			<input type="file" name="ofile" onchange="checkSize(this)" accept=".jpg,.jpeg,.png,.bmp"/>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pass" style="width:150px;"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit" class="btn btn-success">작성 완료</button> &nbsp;&nbsp;
			<button type="reset" class="btn btn-primary"> Reset</button> &nbsp;&nbsp;
			<button type="button" class="btn btn-secondary" onclick="location.href='../h_board/list.do';">
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