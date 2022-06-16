package com.board.cont;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import utils.JSFunction;

public class EditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String idx =req.getParameter("idx");
		HcDAO dao = new HcDAO();
		HcDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/h_board/Edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String saveDirectory =req.getServletContext().getRealPath("/Uploads");
		
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr==null) {
			
			JSFunction.alertLocation(resp,"첨부 파일 용량 초과","../h_board/write.do" );
			
			return;
			
		}
		
		//첨부가있으면 Requent 객체가 아니라 MultipartRequest Form의 변수 값을 받는다
		//업로드 라이브러리 마다 from의 변수 값을 받는 메소드 이름이 다를수 있다(모든 업로드 라이브러리가 getParameter는 아님)
		
		String idx = mr.getParameter("idx");
		String prevOfile =mr.getParameter("prevOfile");
		String prevSfile =mr.getParameter("prevSfile");
		
		String name = mr.getParameter("name");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		HttpSession session = req.getSession();
		String pass =(String)session.getAttribute("pass");
		
		HcDTO dto = new HcDTO();
		dto.setIdx(idx);
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPass(pass);
		
		String fileName = mr.getFilesystemName("ofile");
		if(fileName !=null) {
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext =fileName.substring(fileName.lastIndexOf("."));
			String newFileName=now +ext;
			
			File oldFile = new File(saveDirectory + File.separator +fileName);
			File newFile = new File(saveDirectory + File.separator +newFileName);
			oldFile.renameTo(newFile);
			
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
			
			FileUtil.deleteFile(req, "/Uploads", prevSfile);
			
			
		}else {
			
			dto.setOfile(prevOfile);
			dto.setSfile(prevSfile);
			
		}
		
		HcDAO dao = new HcDAO();
		int result =dao.updatePost(dto);
		dao.close();
		
		
		if(result==1) {
			session.removeAttribute("pass");
			resp.sendRedirect("../h_board/view.do?idx=" + idx);
			
		}else {
			JSFunction.alertLocation(resp, "비밀번호가 일치하지 않습니다!!!!!!", "../h_board/view.do?idx="+idx);
		}
		
		
	}
	
	
	
	
	
	
	

}
