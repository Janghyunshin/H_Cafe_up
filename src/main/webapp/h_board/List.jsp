<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List.jsp (파일첨부 게시판 : MVC)</title>
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
<!-- 추가 항목 2 세션확인-->
<div style = "text-align:right; margin-right:100px;">
<br>
	<%
	 String id =  (String) session.getAttribute("id");
	
	 if (id == null) {
	%>
		<a href = "../h_login/login.do"> 로그인 </a> &nbsp;
		<a href = "../h_login/joinForm.jsp"> 회원가입</a>
	<% 
	 } else {
	%>
		<%=id %> 님이 로그인 하셨습니다.
	<%
	 }
	%>
	</div>
<br><br>
<!--  여기까지 추가 부분 2 -->



	<center>
	<h2> 리뷰 게시판 </h2>
	<br><br>
	</center>
	<!-- 검색폼 -->
	<form method ="get">
		<table class = "table" border="1" >
			<tr>
				<td align="center">
					<select name ="searchField">
						<option value ="title">제목 &nbsp;</option> &nbsp; &nbsp;
						<option value ="content">내용</option> &nbsp; &nbsp;
					</select> &nbsp; 
					<!-- 검색어 자동완성 제거 -->
					<input type ="text" name="searchWord" autocomplete="off"/>&nbsp; 
					
					<input type ="submit" value="검색하기"/>
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 목록 테이블 -->
	<table class = "table table-bordered" border="1"  >
	<center>
		<tr align="center">
			<td width ="8%">NO.</td>
			<td width ="15%">TITLE</td>
			<td width ="15%">POSTED BY</td>
			<td width ="10%">VIEWS</td>
			<td width ="15%">DATE</td>
			<td width ="8%">FILE</td>
		</tr>
	</center>
		<c:choose>
			<c:when test="${empty boardLists }"> <!-- 게시물이 없을때 -->
				<tr>
					<td colspan="6" align="center">
						등록된 게시물이 없습니다
					</td>
				</tr>
			</c:when>
			<c:otherwise>							<!-- 게시물이 존재할때 -->
				<c:forEach items="${boardLists }" var="row" varStatus="loop">
					<tr align="center">
						<td width ="8%"><!-- 번호 -->
							${map.totalCount-(((map.pageNum-1)*map.pageSize) + loop.index)}
						</td>
						<td width ="15%"><!-- 제목(링크) -->
							<a href="../h_board/view.do?idx=${row.idx }">${row.title }</a>
						</td>
						<td width ="15%"><!-- 작성자 -->
							${row.name }
						</td>
						<td width ="10%"><!-- 조회수 -->
							${row.visitcount }
						</td>
						<td width ="15%"><!-- 작성일 -->
							${row.postdate }
						</td>
						<td width ="8%">
							<c:if test="${not empty row.ofile }">
								<a href="../h_board/download.do?ofile=${row.ofile }&sfile=${row.sfile}&idx=${row.idx}">[Down] </a>
							</c:if>
						</td>
					</tr>
					
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	    <!-- 하단 메뉴(바로가기, 글쓰기) -->
    <table class = "table" border="1">
        <tr align = "center">
            <td>
                ${ map.pagingImg }
            </td>
            <td width="100"><button type="button"
                onclick="location.href='../h_board/write.do';">글쓰기</button></td>
        </tr>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 부트 스트랩 소스 -->
</body>
</html>