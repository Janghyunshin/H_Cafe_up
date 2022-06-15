package com.board.cont;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get 요청시 처리 블락
//		System.out.println("ViewController 작동잘됨 (Get 요청)");
		
		//게시물 정보 불러 오기 (1. 조회수 증가, 2. 게시물 정보 가져오기)
		HcDAO dao = new HcDAO();
		String idx = req.getParameter("idx");
		
		//조회수 증가
		dao.updateVisitCount(idx);
		
		//게시물의 자세한 정보 값 가져오기
		HcDTO dto = dao.selectView(idx);
		dao.close();
		
		
		//DB의 content 컬럼의 \r\n을 <==<<Enter>>를 "<br/>" 태그로 변환
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		//게시물(dto) 객체를 view페이지로 전달하기 위한 변수 값 저장
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/h_board/View.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Post 요청시 처리 블락
		
//		System.out.println("ViewController 작동잘됨 (Post 요청)");
	}
	
}
