<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
	<title>회원정보 변경</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="../h_login/login.css"/>

</head>
<body>

	<section id="regForm" class="login_form" align="center">
		<h1> 회원정보 변경  </h1>
		<p>
			<center> 수정 페이지 입니다
					<hr>
				  * 아이디는 변경 불가능 *
			</center>
		</p>
		
		<form action="update.do" method = "post">
	   		<div class="int_area">
				<label for="member_id">아이디</label>
	          	<input name="member_id" type="text" value ="<%=session.getAttribute("id")%>" readonly />
	        </div>
			<div class="int_area">
				<label for="member_pw">비밀번호</label>
	          	<input name="member_pw" type="password" required="required" placeholder="비밀번호를 입력하세요" autocomplete="off"/>
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
	          	placeholder="휴대폰 번호를 입력해 주세요." autocomplete="off" />
	        </div>
			<tr>
				<td colspan="2" align="center">
				<br>
					<input type="submit" value="내용 수정"/> &nbsp;
					<input type="button" value="회원 탈퇴" onclick="location.href='delete.do'"/> &nbsp;
					<input type="button" value="돌아 가기" onclick="location.href='../h_main/index.jsp'"/>
				</td>
			</tr>
	      </form>
	</section>

</body>
</html>