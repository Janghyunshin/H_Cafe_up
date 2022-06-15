<%@page import="com.member.hp.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member detailForm JSP</title>
<script type="text/javascript">
function fnSubmit() {
	if(confirm("정말 수정하시겠습니까?")) {
		return true;
	}
	return false;
}
</script>
</head>
<body>
<div align="center">
	<h3>[회원정보 수정]</h3>
	<form action="update.do" method="post" onsubmit="fnSubmit()">
	<input type="hidden" name="member_id" value="<%=dto.getMember_id() %>" />
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><%=dto.getMember_id() %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="member_pw" value="<%=dto.getMember_pw() %>" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="member_name" value="<%=dto.getMember_name() %>" /></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="member_age" value="<%=dto.getMember_age() %>" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="member_address" value="<%=dto.getMember_address() %>" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="member_tel" value="<%=dto.getMember_tel() %>" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" />
					<input type="reset" value="초기화하기" />
					<input type="button" value="게시판 보기" onclick="location.href='b_list.do'" /> 
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
