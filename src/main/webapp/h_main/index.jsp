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
    <link rel="stylesheet"  type="text/css"  href="css/main.css">
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
        <div class="banner">
			<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
			  <div class="carousel-inner">
			    <div class="carousel-item active" data-bs-interval="10000">
			      <img src="images/salady01.png" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item" data-bs-interval="2000">
			      <img src="images/salady02.png" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item">
			      <img src="images/salady03.jpg" class="d-block w-100" alt="...">
			    </div>
			  </div>
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
        </div>
        <div class="main_products">
            <!-- 인기 상품  -->
            <h2>Best products</h2>
        </div>
        <div class="container">
            <!-- 부트스트랩 그리드 시작  -->
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <!-- 웹페이지에서는 가로 제품 3개 / 모바일환경에서는 2개씩  2 1 / 2 1 로 보이게 형성  -->
                    <div class="b_products">
                        <!-- 인기상품 1 -->
                        <ul class="b_products_list">
                            <li> 
                                <img src="images/bowl_01.jpg" alt="칠리 베이컨 웜볼">
                                <p>칠리 베이컨 웜볼</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="b_products">
                        <!-- 인기상품 2 -->
                        <ul class="b_products_list">
                            <li> 
                                <img src="images/salad_03.jpg" alt="우삼겹 메밀면 샐러드">
                                <p>우삼겹 메밀면 샐러드</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="b_products">
                        <!-- 인기상품 3 -->
                        <ul class="b_products_list">
                            <li> 
                                <img src="images/wrap_01.png" alt="멕시칸 랩">
                                <p>멕시칸 랩</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- 부트스트랩 그리드 종료 -->
    </main>
    <!-- 메인 종료 -->
	<%@ include file ="footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 부트 스트랩 소스 -->
</body>
</html>