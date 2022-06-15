<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>

<%@ include file ="../h_main/header.jsp" %>
<center>
	<br><br>	
	<h2> 게시판 : 상세보기 </h2>
	<br><br>
</center>


<table border ="1" width ="90%" class = "table table-bordered">
	<colgroup>
		<col width="15%"/><col width="35%"/>
		<col width="15%"/><col width="*"/>
	</colgroup>
	
	<!-- 게시글 정보 -->
	<tr>
		<td>번호</td> <td>${dto.idx }</td>
		<td>작성자</td> <td>${dto.name }</td>
	</tr>
	
	<tr>
		<td>작성일</td> <td>${dto.postdate }</td>
		<td>조회수</td> <td>${dto.visitcount }</td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td colspan="3">${dto.title }</td>
	</tr>
	
	<tr>
		<td>내용</td>
		<td colspan="3" height="100">${dto.content }
		<p><img src="../h_board/download.do?ofile=${dto.ofile }&sfile=${dto.sfile }&idx=${dto.idx } alt="image"></p>
		
		</td>
	</tr>
	
	<!-- 첨부파일 -->
	<tr>
		<td>첨부파일</td>
		<td>
			<c:if test="${not empty dto.ofile }">
			${dto.ofile }
			<a href ="../h_board/download.do?ofile=${dto.ofile }&sfile=${dto.sfile }&idx=${dto.idx }">
				[다운로드]
			</a>
			</c:if>
		</td>
		<td>다운로드수</td>
		<td>${dto.downcount }</td>
	</tr>
	<!-- 하단 메뉴버튼	 -->
	<tr>
		<td colspan="4" align="center">
			<button type="button" onclick="location.href='../h_board/pass.do?mode=edit&idx=${param.idx}';">
				수정하기
			</button>
			<button type="button" onclick="location.href='../h_board/pass.do?mode=delete&idx=${param.idx}';">
				삭제하기
			</button>
			<button type="button" onclick="location.href='../h_board/list.do';">
				목록 바로가기
			</button>
		</td>
	</tr>
</table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 부트 스트랩 소스 -->
</body>
</html>