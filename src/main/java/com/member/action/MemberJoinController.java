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
//		boolean result = dao.joinMember(dto);
		int succ = dao.joinMember(dto);
		System.out.println("테스트:" + succ);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
//		if(result == false) {
		if(succ == 0) {
			System.out.println("실패");
			
			out.println("<script>alert('회원가입 실패!');");
			out.println("location.href='join.do';</script>");
			
			JSFunction.alertBack(response, "실패");
			// 회원가입 실패시 콘솔 창에 정보 출력
			System.out.println("회원가입 실패");
		} else {
			System.out.println("성공");
			// 현재 out.println 먹통
			
			
			out.println("<script>");
			out.println("alert('회원가입 성공!');");
			out.println("location.href='login.jsp';");
			out.println("</script>");
			
			
			JSFunction.alertLocation(response, "성공", "/h_login/loginForm.jsp");
			// 회원가입 성공시 콘솔 창에 정보 출력
			System.out.println("회원가입 성공");
		}
		
		request.getRequestDispatcher("/h_login/joinForm.jsp").forward(request, response);

		
		
	}

}
