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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(name = "add", urlPatterns = { "/add.do" })
public class BoardAddController extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Get 방식 요청 처리
		//board_list 에서 글쓰기 클릭 했을때  로그인 페이지(board_write.jsp)
		
		//뷰페이지로 이동
		 request.getRequestDispatcher("/h_board/board_write.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String saveFoleder = "boardupload";
//		String realFolder = request.getRealPath(saveFoleder);
		
		String realFolder = ""; //저장 경로
		realFolder = "C:\\SJH\\P_Hpcafe\\src\\main\\webapp\\upload";
		int fileSize = 5 * 1024 * 1024; //5MB
		//fileSize = byte 단위로 들어간다
		
		MultipartRequest multi = null; //파일 업로드 처리
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy(); //중복 파일 명 방지
		multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", policy);
		
		BoardDTO dto = new BoardDTO(); //BoardBean, BoardVo 라고도 부른다.
		dto.setBoard_id(multi.getParameter("board_id"));
		dto.setBoard_subject(multi.getParameter("board_subject"));
		dto.setBoard_content(multi.getParameter("board_content"));
		dto.setBoard_file(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		
		//System.out.println(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
		
		BoardDAO dao = new BoardDAO(); //BoardService 라고도 부른다
		int succ = dao.boardInsert(dto);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(succ > 0) {
			out.println("<script>alert('등록 성공');");
			out.println("location.href='b_list.do';</script>");
		} else {
			out.println("<script>alert('등록 실패');");
			out.println("location.href='b_list.do';</script>");
		}
		
		
	}

}
