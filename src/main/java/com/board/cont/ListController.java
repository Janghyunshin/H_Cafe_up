package com.board.cont;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.BoardPage;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Client에서 Get 방식으로 요청할 경우 처리하는 블락
		
		HttpSession session = req.getSession(); // *추가 1*
		
		//1. DAO 객체 생성(Model : 비즈니스 로직 처리)
		HcDAO dao = new HcDAO();
		
		//2. view에 전달할 매개변수 저장용 맵 생성
		Map<String, Object> map = new HashMap<String, Object>();
		
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		
		if(searchWord != null) {	//검색어가 존재한다면 map에 값을 저장
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		
		//게시물 갯수 알아오기 (DAO에 selectCount(map))
		
		int totalCount = dao.selectCount(map);
//		System.out.println("전체 레코드수 : " + totalCount);
//		System.out.println("list.do 요청시 Controller페이지 응답 완료");
		
		/* 페이징 처리 부분 start */
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
		
//		System.out.println(pageSize);
//		System.out.println(blockPage);
		
		//현재 페이지 확인
		int pageNum =1;
		String pageTemp = req.getParameter("pageNum");
		System.out.println("컨트롤러 페이지템프: " +pageTemp);
		if(pageTemp != null && !pageTemp.equals("")) {
			pageNum =Integer.parseInt(pageTemp);	//값이 비어 있지 않을때 넘어온 페이지 변수를 정수로 변환
		}
		
		//목록에 출력할 게시물 범위 계산
		int start = (pageNum-1) * pageSize +1 ; //첫 게시물 번호
		int end = pageNum * pageSize; 	//마지막 게시물 번호
		
		//뷰 페이지에 값을 던져줌
		map.put("start", start);
		map.put("end", end);
		
		
		
		/* 페이징 처리 부분 end */
		
		//게시물 목록을 받아오기 (DAO 객체에 작업을 전달)
			//boardLists는 DB의 레코드를 담은 DTO 객체를 담고 있다(레코드 수 만큼.
		List<HcDTO> boardLists = dao.selectListPage(map);
		dao.close();
		
		//view 페이지에 전달할 매개변수들을 추가
		String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "../h_board/list.do");
		
		//View페이지로 변수의 값을 전달
		
		map.put("pagingImg", pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		
		//view 페이지로 데이터 전달, request 영역에 전달할 데이터를 저장후 List.jsp(뷰페이지)로 포워드
		req.setAttribute("boardLists", boardLists);	//DB에서 Select한 결과값
		req.setAttribute("map", map);
		req.getRequestDispatcher("/h_board/List.jsp").forward(req, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Client에서 post 방식으로 요청할 경우 처리하는 블락
		
	}
	
}
