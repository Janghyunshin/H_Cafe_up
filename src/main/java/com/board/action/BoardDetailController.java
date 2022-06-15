package com.board.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.hp.BoardDAO;
import com.board.hp.BoardDTO;


@WebServlet(name = "b_detail", urlPatterns = { "/b_detail.do" })
public class BoardDetailController extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getDetail(board_num);
		if(!id.equals(dto.getBoard_id())) {	//작성자와 로그인 id가 같을경우 조회수가 증가하지 않음
			dao.readCount(board_num);	//조회수 증가
		}
		dto = dao.getDetail(board_num);	//증가한 조회수를 가져옴
		request.setAttribute("dto", dto);
		
		request.getRequestDispatcher("h_board/board_view.jsp").forward(request, response);
		//request.getRequestDispatcher("board_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
	}

}
