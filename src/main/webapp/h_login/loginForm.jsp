<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="../h_login/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	
</head>
<body>
    <!-- 로그인 폼 디자인 참고: 영국 나이키-->
    <section class="login_form" border="1">
        <h1>ID 로그인</h1>
        <form action="login.do" method="post">
            <div class="int_area">
                <!-- 아이디 폼 -->
                <input type="text" name="member_id" autocomplete="off" required>
                <label for="id">아이디</label>
            </div>
            <div class="int_area">
                <!-- 패스워드 폼 -->
                <input type="password" name="member_pw" autocomplete="off" required>
                <label for="id">비밀번호</label>
            </div>
            <input class="remember" type="checkbox" name="remember" value="signed" > 로그인 상태 유지
            <!-- 계정 정보 기억 체크 박스 -->
            <div class="btn_area">
            	<button type="submit" > 로그인 </button>
            </div>      
        </form>
        <div class="caption">
        	<a href="">비밀번호 찾기</a>
        	<!-- 비밀번호 찾기 -->
        	<p></p>
       		 멤버가 아니세요? <a href="../h_login/joinForm.jsp"> 회원가입 </a>
        <!-- Join us 클릭하면 회원가입으로 이동 -->
        </div>
    </section>
    

</body>
</html>