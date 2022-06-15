package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.hp.BoardDAO;
import com.board.hp.BoardDTO;

@WebServlet(name = "b_modify", urlPatterns = { "/b_modify.do" })
public class BoardModifyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDTO dto = new BoardDTO();
		dto.setBoard_num(board_num);
		dto.setBoard_subject(request.getParameter("board_subject"));
		dto.setBoard_content(request.getParameter("board_content"));
		
		BoardDAO dao = new BoardDAO();
		int succ = dao.boardUpdate(dto);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(succ > 0) {
			out.println("<script>alert('수정되었습니다!');");
			out.println("location.href='boardDetailAction.bo?board_num=" + board_num + "';</script>");
		} else {
			out.println("<script>alert('수정 실패!');");
			out.println("location.href='boardDetailAction.bo?board_num=" + board_num + "';</script>");
		}
		
		request.getRequestDispatcher("h_board/board_modify.jsp").forward(request, response);
		
	}

}
