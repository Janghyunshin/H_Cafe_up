package com.board.cont;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fileupload.FileUtil;
import utils.JSFunction;

public class PassController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get 요청시 처리
		
		System.out.println("PassController 정상작동");
		
		//mode: edit <==글수정, mode: delete <== 글삭제
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/h_board/Pass.jsp").forward(req, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Post 요청시 처리
		
		String idx =req.getParameter("idx");
		String mode =req.getParameter("mode");
		String pass =req.getParameter("pass");
		
		HcDAO dao = new HcDAO();
		boolean confirmed = dao.confirmPassword(pass, idx);
		dao.close();
		
		if(confirmed) {
			if(mode.equals("edit")) {
				HttpSession session =req.getSession();
				session.setAttribute("pass", pass);
				resp.sendRedirect("../h_board/edit.do?idx=" +idx);
			}else if(mode.equals("delete")){
				dao = new HcDAO();
				HcDTO dto =dao.selectView(idx);
				int result = dao.deletePost(idx);
				dao.close();
				if(result==1) {
					String saveFileName=dto.getSfile();
					FileUtil.deleteFile(req, "/Uploads", saveFileName);
				}
				JSFunction.alertLocation(resp, "삭제되었습니다.", "../h_board/list.do");
			}
		}else{
			JSFunction.alertBack(resp, "비밀번호가 일치하지 않습니다.");
		}
		
		
		
		
		
		
		
	}
	
	

}
