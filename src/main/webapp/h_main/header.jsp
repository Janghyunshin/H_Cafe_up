<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title> HP Cafe </title>
    <style type="text/css"> 
	a { text-decoration:none } 
	</style>
	<!-- 하이퍼링크 밑줄 없애기 --> 
</head>
<body>
    <header>
    <!-- 헤더 시작 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <!-- 부트스트랩 네비바 사용-->
        <div class="container-fluid">
            <img src="../h_main/images/logo.png" alt="로고">
                <!-- footer 왼쪽 로고 -->
            <a class="navbar-brand" href="#">HP Cafe</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                <!-- HP Cafe 버튼 -->
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../h_main/index.jsp">Home</a>
                        <!-- 홈 버튼 : index.html로 링크-->
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">소개</a>
                        
                    </li>
                    <li class="nav-item dropdown">
                        <!-- 드랍다운 1 -->
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            메뉴
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="../h_main/bowl.jsp">보울</a></li>
                            <li><a class="dropdown-item" href="../h_main/salad.jsp">샐러드</a></li>
                            <li><a class="dropdown-item" href="../h_main/sandNwrap.jsp">샌드&랩</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <!-- 드랍 다운 2 -->
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            커뮤니티
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">1:1 문의</a></li>
                            <li><a class="dropdown-item" href="../h_board/list.do">리뷰</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- 로그인 + 마이페이지 + 장바구니 -->
                <div class="icon-link" align="right">
                    <!-- 원본 (아이콘을 이옹한 링크)
                    <a href="../h_login/loginForm.jsp"><img src="images/log.png" alt="로그인"></a>
                    <a href="#"><img src="images/cart.png" alt="장바구니"></a>
                    -->
                    <%if (session.getAttribute("id")==null) { %>
					<a href="../h_login/join.do"> 회원가입 </a> &nbsp; &nbsp; &nbsp;
					<a href="../h_login/login.do"> 로그인 </a> &nbsp; &nbsp; &nbsp;
					
					<%}else { %>
					<span><%=session.getAttribute("id") %> 님 반갑습니다 &nbsp; &nbsp; </span>
					<a href="../h_login/update.do" > 정보수정 &nbsp; &nbsp; </a>
					<a href="../h_login/logout.do" > 로그아웃 &nbsp; &nbsp; </a>
					<% } %>
					
                </div>
                <form class="d-flex">
                    <!-- 검색 바 -->
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>

            </div>
        </div>
        <!-- 네비바 종료 -->
    </nav>
    </header>
    <!-- 헤더 끝 -->
  </body>
</html>