<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
	<title>회원가입 페이지</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="../h_login/login.css"/>
	<script src="../js/jquery-1.11.0.min.js"></script>
	<script src="register.js"></script>

</head>
<body>

	<section id="regForm" class="login_form" align="center">
		<h1> 회원가입 </h1>
		<p>
			<center> 멤버가 되어 새로운 소식
					<hr>
					다양한 혜택을 만나보세요.
			</center>
		</p>
		
		<form action="join.do" method = "post">
	   		<div class="int_area">
				<label for="member_id">아이디</label>
	          	<input name="member_id" type="text" required="required"
					placeholder="사용하실 ID를 입력해주세요 (수신 가능 E-mail)" autocomplete="off" />
	        </div>
			<div class="int_area">
				<label for="member_pw">비밀번호</label>
	          	<input name="member_pw" type="password" required="required" placeholder="8~16자 숫자,문자,특수문자를 사용한 비밀번호" autocomplete="off"/>
	        </div>
	        <div class="int_area">
	      		<label for="member_name">이름</label>
	          	<input type="text" name="member_name" required="required" placeholder="이름을 입력해 주세요" autocomplete="off"/>
	        </div>
	        <div class="int_area">
	      		<label for="member_age">나이</label>
				<input type="number" name="member_age" required="required" min="0" placeholder="나이를 입력해 주세요" autocomplete="off"/>
	        </div>
	        <div class="int_area">
	     		<label for="member_address">주소</label>
	          	<input name="member_address" type="text" required="required" placeholder="주소를 입력해주세요" autocomplete="off" />
	        </div>
	        <div class="int_area">
	      		<label for="member_tel">전화번호</label>
	          	<input name="member_tel" type="text" required="required" 
	          	placeholder="휴대폰 번호를 '-' 표시없이 입력해 주세요." autocomplete="off" />
	        </div>
			<tr>
				<td colspan="2" align="center">
				<br>
					<input type="submit" value="회원가입"/> &nbsp;
					<input type="reset" value="다시 작성"/> &nbsp;
					<input type="button" value="로그인" onclick="location.href='login.do'"/>
				</td>
			</tr>
	      </form>
	</section>

</body>
</html>