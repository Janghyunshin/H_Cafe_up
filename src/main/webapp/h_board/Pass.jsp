<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
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
	if(form.pass.value ==""){
		alert("비밀번호를 입력해주세요.");
		form.pass.focus();
		return false;
	}
	
}
</script>
</head>
<body>
<%@ include file ="../h_main/header.jsp" %>
<center>
	<br><br>	
	<h2>파일 첨부형 게시판 - 비밀번호 검증(Pass)</h2>
	<br><br>
</center>

<form name="writeFrm" method="post" action="../h_board/pass.do" onsubmit="return validateForm(this);">
<input type="hidden" name="idx" value="${param.idx }"/>
<input type="hidden" name="mode" value="${param.mode }"/>
<table border="1" width="90%" class="table">
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pass" sytle="width:100px;"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit">검증하기</button> &nbsp;&nbsp;
			<button type="reset">RESET</button> &nbsp;&nbsp;
			<button type="button" onclick="location.href='../h_board/list.do';">
				목록 바로가기
			</button>
		</td>
	<tr>
	
</table>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 부트 스트랩 소스 -->
</body>
</html>