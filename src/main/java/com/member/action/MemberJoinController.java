package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.hp.MemberDAO;
import com.member.hp.MemberDTO;

import utils.JSFunction;

@WebServlet(name = "join", urlPatterns = { "/join.do" })
public class MemberJoinController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//String member_id = request.getParameter("member-id");
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(request.getParameter("member_id"));
		dto.setMember_pw(request.getParameter("member_pw"));
		dto.setMember_name(request.getParameter("member_name"));
		dto.setMember_age(Integer.parseInt(request.getParameter("member_age")));
		dto.setMember_address(request.getParameter("member_address"));
		dto.setMember_tel(request.getParameter("member_tel"));
		
		MemberDAO dao = new MemberDAO();
		int succ = dao.joinMember(dto);
		//System.out.println("테스트:" + succ);
		
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		if(succ == 0) {
			
			out.println("<script>alert('회원가입 실패!');");
			out.println("location.href='join.do';</script>");
			
			// 회원가입 실패시 콘솔 창에 정보 출력
			System.out.println("회원가입 실패");
			
			out.flush(); 	// flush() 실행하지 않을시 PrintWriter가 작동되지 않음
			
		} else {
			
			out.println("<script>");
			out.println("alert('회원가입 성공!');");
			out.println("location.href='loginForm.jsp';");
			out.println("</script>");
			out.flush();	// flush() 실행하지 않을시 PrintWriter가 작동되지 않음
			
			// 회원가입 성공시 콘솔 창에 정보 출력
			System.out.println("회원가입 성공");
		}
		

		
		
	}

}
