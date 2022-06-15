package com.board.cont;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileupload.FileUtil;

public class DownloadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//매개 변수 받기 (Get의 변수 값 받기)
		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		String idx = req.getParameter("idx");
		
		//파일 다운로드 처리(FileUtil의 download 메소드 호출)
		FileUtil.download(req, resp, "/Uploads", sfile, ofile);
		
		//게시물의 다운로드수 1증가
		HcDAO dao = new HcDAO();
		dao.downCountPlus(idx);
		dao.close();
	}
	
}
