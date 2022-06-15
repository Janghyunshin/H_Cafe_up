package com.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.hp.MemberDAO;
import com.member.hp.MemberDTO;

@WebServlet(name = "detail", urlPatterns = { "/detail.do" })
public class MemberDetailController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String member_id = request.getParameter("member_id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getDetailMember(member_id);
		request.setAttribute("dto", dto);
		
		
		request.getRequestDispatcher("h_login/member_detailForm.jsp").forward(request, response);
		
	}

}
