<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
	<title>회원탈퇴 페이지</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="../h_login/login.css"/>
	<script src="../js/jquery-1.11.0.min.js"></script>
	<script src="register.js"></script>

</head>
<body>

	<section id="regForm" class="login_form" align="center">
		<h1> 회원탈퇴 </h1>
		<p>
			<center> 회원 탈퇴 페이지 입니다.
					<hr>
					 신중히 생각해 주세요!
			</center>
		</p>
		
		<form action="delete.do" method = "post">
	   		<div class="int_area">
				<label for="member_id">아이디</label>
	          	<input name="member_id" type="text" value ="<%=session.getAttribute("id")%>" readonly />
	        </div>
			<div class="int_area">
				<label for="member_pw">비밀번호</label>
	          	<input name="member_pw" type="password" required="required" placeholder="비밀번호를 입력해 주세요" autocomplete="off"/>
	        </div>

			<tr>
				<td colspan="2" align="center">
				<br>
					<input type="submit" value="삭제 하기"/> &nbsp;
					<input type="reset" value="다시 작성"/> &nbsp;
					<input type="button" value="돌아 가기" onclick="location.href='../h_main/index.jsp'"/>
				</td>
			</tr>
	      </form>
	</section>

</body>
</html>