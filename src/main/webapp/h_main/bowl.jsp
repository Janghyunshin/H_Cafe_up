<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> HP Cafe </title>
    <link rel="stylesheet"  type="text/css"  href="css/products.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- 부트 스트랩 링크 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <!-- 글꼴 링크 -->
    
    <style type="text/css"> 
	a { text-decoration:none } 
	</style>
	<!-- 하이퍼링크 밑줄 없애기 --> 
</head>
<body>
<%@ include file ="header.jsp" %>

    <main>
    <!-- 메인 시작  -->
        <div class="main_products">
            <h2>도시락</h2>
        </div>
        <div class="container">
            <!-- 부트스트랩 그리드 시작  -->
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <!-- 웹페이지에서는 가로 제품 3개 / 모바일환경에서는 2개씩  2 1 / 2 1 로 보이게 형성  -->
                    <div class="m_products">
                        <!-- 보울 1 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/bowl_01.jpg" alt="칠리베이컨 웜볼">
                                <p>칠리베이컨 웜볼</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 보울 2 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/bowl_02.jpg" alt="우삼겹 웜볼">
                                <p>우삼겹 웜볼</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 보울 3 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/bowl_03.jpg" alt="팔라펠단호박 웜볼">
                                <p>팔라펠단호박 웜볼</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 보울 4 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/bowl_04.jpg" alt="고추장머쉬룸 웜볼">
                                <p>고추장머쉬룸 웜볼</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 보울 5 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/bowl_05.jpg"alt="할라피뇨치킨 웜볼">
                                <p>할라피뇨치킨 웜볼</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 부트스트랩 그리드 종료 -->
    </main>
    <!-- 메인 종료 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 부트 스트랩 소스 -->

<%@ include file ="footer.jsp" %>
</body>
</html>