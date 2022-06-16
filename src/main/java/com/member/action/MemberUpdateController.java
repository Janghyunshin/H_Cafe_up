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

import utils.JSFunction;

@WebServlet(name = "update", urlPatterns = { "/update.do" })
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		// 뷰 페이지로 이동
		 request.getRequestDispatcher("/h_login/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		MemberDTO dto = new MemberDTO();
		dto.setMember_pw(request.getParameter("member_pw"));
		dto.setMember_name(request.getParameter("member_name"));
		dto.setMember_age(Integer.parseInt(request.getParameter("member_age")));
		dto.setMember_address(request.getParameter("member_address"));
		dto.setMember_tel(request.getParameter("member_tel"));
		dto.setMember_id(request.getParameter("member_id"));
			
		MemberDAO dao = new MemberDAO();
		int result = dao.updateMember(dto);
		System.out.println("테스트 :" + result);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
//		if(result == false) {
		if(result == 0) {
			System.out.println("수정 실패");
			
			out.println("<script>alert('회원정보 수정 실패!');");
			out.println("location.href='update.do';</script>");
			// 회원가입 실패시 콘솔 창에 정보 출력
			System.out.println("회원정보 수정 실패");
			out.flush();
			
		} else {
			System.out.println("수정 성공");
			// 현재 out.println 먹통
		
			out.println("<script>");
			out.println("alert('회원정보 수정 성공!');");
			out.println("location.href='../h_main/index.jsp';");
			out.println("</script>");
			out.flush();
			
			
			// 회원가입 성공시 콘솔 창에 정보 출력
			System.out.println("회원정보 수정 성공");
		}
		
		//request.getRequestDispatcher("/h_login/update.jsp").forward(request, response);

		
	}

}
