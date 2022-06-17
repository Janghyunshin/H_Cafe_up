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

public class WriteController extends HttpServlet {
	
	String ext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get 방식 요청 처리
		//List.jsp(view 페이지) 에서 글쓰기를 클릭 했을때 글쓰기 뷰페이지(Write.jsp)
		
		
		// 세션값을 받기 위해
		HttpSession session = req.getSession();
		//뷰페이지로 이동
		req.getRequestDispatcher("/h_board/Write.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Post 방식 요청 처리
		//Write.jsp 페이지에서 전송을 클릭했을때 from에서 넘어오는 변수의 값을 처리
		
		//form에서 파일을 전송하므로 cos.jar 라이브러리의 객체 생성후 변수의 값을 받아야 한다.
		String saveDirectory =req.getServletContext().getRealPath("/Uploads");
		
		ServletContext application = getServletContext();
		int maxPostSize =Integer.parseInt(application.getInitParameter("maxPostSize"));	
		
		//1.파일 업로드 처리====================================
			//saveDtriectory 변수에 업로드할 파일을 저장할 서버의 물리적인 경로를 저장.
		//파일업로드 객체 생성
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		
		//객체 생성 실패시 처리 할 내용
		if(mr==null) {	//객체 생성 실패( 1MB 이상의 용량의 파일 전송시)
			
			JSFunction.alertLocation(resp,"첨부 파일 용량 초과","../h_board/write.do");
			
			return;
		}
		
		//2.파일 업로드 외 처리(form의 변수 값처리)===================================
			//폼에서 넘겨받은 값을 받아서 DTO(VO)에 Setter 주입을 하고 DAO에 Insert 매소드에 던져줌
		
		HcDTO dto = new HcDTO();
		dto.setName(mr.getParameter("name"));
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		dto.setPass(mr.getParameter("pass"));
		
		
		String fileName =mr.getFilesystemName("ofile");
		if(fileName!=null) {
			
			//새로운 파일이름으로 변경해서 서버에 저장함.( 서버의 해당파일과 동일한 이름이 존재할 경우가 있으므로)
			String now =new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
				System.out.println("now : " + now);
			String ext = fileName.substring(fileName.lastIndexOf("."));
				System.out.println("ext : " + ext);	
			String newFileName =now + ext;
			System.out.println("newFileName : " +newFileName);
			
			File oldFile = new File(saveDirectory +File.separator + fileName);
			File newFile = new File(saveDirectory +File.separator + newFileName);
				System.out.println("oldFIle : " +oldFile);
				System.out.println("newFIle : " +newFile);
			oldFile.renameTo(newFile);
			
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
			
		}
		
		HcDAO dao = new HcDAO();
		
		int result =dao.insertWrite(dto);
		
		//객체 종료 메소드 호출 (rs, stmt,psmt, con 모두 종료)
		dao.close();
		
		
		//글쓰기 성공일때 이동할 페이지
		if(result ==1 ) {
			resp.sendRedirect("../h_board/list.do");
			
		//글쓰기 실패일때 이동할 페이지
		} else {
			resp.sendRedirect("../h_board/write.do");
		}
		
		
	}
	

}
