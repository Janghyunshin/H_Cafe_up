package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.hp.MemberDAO;
import com.member.hp.MemberDTO;

public class MemberLoginController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get 방식 요청 처리
		// index.html 에서 자동이동
		// joinForm.jsp 에서 로그인을 클릭 했을때  로그인 페이지(loginForm.jsp)
		
		//뷰페이지로 이동
		 request.getRequestDispatcher("/h_login/loginForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(request.getParameter("member_id"));
		dto.setMember_pw(request.getParameter("member_pw"));

		MemberDAO dao = new MemberDAO();
		int result = dao.isMember(dto.getMember_id(), dto.getMember_pw());
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다!');");
				out.println("location.href = 'login.do';");
			out.println("</script>");
			out.flush();
			//response.sendRedirect("/h_login/loginform.jsp");

		} else if(result == -1) {
			out.println("<script>");
				out.println("alert('아이디가 존재하지 않습니다!');");
				out.println("location.href = 'login.do';");
			out.println("</script>");
			out.flush();
			//response.sendRedirect("/h_login/loginform.jsp");

		} else {	//로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("id", dto.getMember_id()); //바인딩 객체
			out.println("<script>");
			out.println("alert('로그인에 성공했습니다!');");
			out.println("location.href = '../h_main/index.jsp';");
			out.println("</script>");
			out.flush();
			//response.sendRedirect("../h_main/index.jsp");
		}
	
	
	}
		
}
