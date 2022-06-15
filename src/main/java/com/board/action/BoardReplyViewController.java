package com.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.hp.BoardDAO;
import com.board.hp.BoardDTO;

@WebServlet(name = "b_replyView", urlPatterns = { "/b_replyView.do" })
public class BoardReplyViewController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getDetail(board_num);
		request.setAttribute("dto", dto);
		
		request.getRequestDispatcher("/h_board/board_reply.jsp").forward(request, response);
		
		
	}

}
