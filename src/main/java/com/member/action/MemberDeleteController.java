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

@WebServlet(name = "delete", urlPatterns = { "/delete.do" })
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.getRequestDispatcher("/h_login/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(request.getParameter("member_id"));
		dto.setMember_pw(request.getParameter("member_pw"));
		
		System.out.println(dto.getMember_id());
		System.out.println(dto.getMember_pw());
		
		MemberDAO dao = new MemberDAO();
		int result = dao.deleteMember(dto.getMember_id(), dto.getMember_pw());
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();


		if(result == 1) {	// 탈퇴성공
	
			out.println("<script>");
			out.println("alert('회원 탈퇴에 성공했습니다 !');");
			out.println("location.href = '../h_main/index.jsp';");
			out.println("</script>");
			System.out.println(result);
			session.invalidate();
			
			out.flush();
			
		} else { 		// 탈퇴 실패
				out.println("<script>");
					out.println("alert('회원 정보가 일치하지 않습니다 !');");
					out.println("location.href = 'delete.jsp';");
				out.println("</script>");
				System.out.println(result);
				
				out.flush();	
			
		}
		
	}

}
