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
            <h2>샌드 & 랩</h2>
        </div>
        <div class="container">
            <!-- 부트스트랩 그리드 시작  -->
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <!-- 웹페이지에서는 가로에 제품 2개씩 모바일에서는 가로로 1개씩 보이게 -->
                    <div class="m_products">
                        <!-- 샌드&랩 1 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/sand_01.jpg" alt="콜드컷 샌드">
                                <p>콜드컷 샌드</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 샌드&랩 2 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/sand_02.jpg" alt="치킨토마토 샌드">
                                <p>치킨토마토 샌드</p>
                            </li>
                        </ul>
                    </div>
                </div>
				<div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 샌드&랩 3 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/sand_03.jpg" alt="에그베이컨 샌드">
                                <p>에그베이컨 샌드</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 샌드&랩 4  -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/wrap_01.png" alt="맥시칸 랩">
                                <p>맥시칸 랩</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 샌드&랩 5 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/wrap_02.png" alt="시저치킨 랩">
                                <p>시저치킨 랩</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="m_products">
                        <!-- 샌드&랩 6 -->
                        <ul class="m_products_list">
                            <li> 
                                <img src="images/wrap_03.png" alt="크랜배리그릭 랩">
                                <p>크랜배리그릭 랩</p>
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