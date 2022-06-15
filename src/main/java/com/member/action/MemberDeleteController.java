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


@WebServlet(name = "delete", urlPatterns = { "/delete.do" })
public class MemberDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		
		if(id == null) {	//ID체크 후 없으면 로그인 화면으로
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('해당 ID가 없습니다!');");
			out.println("location.href='login.do';</script>");
			
		} else if(!id.equals("admin")) {	//어드민이 아니면 게시글 목록 화면으로
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자가 아닙니다!');");
			out.println("location.href='boardList.bo';</script>");
			
		} else {	//관리자 계정이라면
			/*
			//제대로 접근되는지 확인
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자로 로그인 하셨습니다!');</script>");
			*/
			request.setCharacterEncoding("utf-8");
			String member_id = request.getParameter("member_id");
			MemberDAO dao = new MemberDAO(); 
			dao.deleteMember(member_id);
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('삭제 완료되었습니다.!');");
			out.println("location.href='memberList.do';</script>");
		}
	
			request.getRequestDispatcher("h_login/member_list.jsp").forward(request, response);
	}

}
