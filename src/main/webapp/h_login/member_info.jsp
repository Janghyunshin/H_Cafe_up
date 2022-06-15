<%@page import="com.member.hp.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member info JSP</title>
</head>
<body>
<div align="center">
	<h3>[회원 정보 상세 보기]</h3>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><%=dto.getMember_id() %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<%
			int pwLength = dto.getMember_pw().length();
			String mark = dto.getMember_pw().substring(0, 2);
			for(int i = 0; i < pwLength - 2; i++) {
				mark += "*";
			}
			out.println("<td>" + mark + "</td>");
			%>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=dto.getMember_name() %></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=dto.getMember_age() %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=dto.getMember_address() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getMember_tel() %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원 목록 보기" onclick="location.href='memberList.do'" />
				<input type="button" value="게시판 보기" onclick="location.href='b_list.do'" />
				<input type="button" value="로그아웃" onclick="location.href='login.do'" />
			</td>
		</tr>
	</table>
</div>
</body>
</html>
