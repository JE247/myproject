package kr.co.jhta.project.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.co.jhta.project.action.Action;
import kr.co.jhta.project.action.LoginActionCommend;
import kr.co.jhta.project.action.LoginFormActionCommand;
import kr.co.jhta.project.action.MainActionCommand;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

@WebServlet("/MyProjectLogin.do")
public class LoginController extends HttpServlet{
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id != null) {
			int eno = Integer.parseInt(id);

			OfficeWorkerDAO dao = new OfficeWorkerDAO();
			OfficeWorkerDTO dto = new OfficeWorkerDTO();
			
			dto.setEno(eno);
			dto.setPassword(pw);
			
			OfficeWorkerDTO loginDto = dao.login(dto);
			
			String url = "";
			
			if(loginDto != null) {
				
				request.setAttribute("login", "true");
				HttpSession session = request.getSession();
				session.setAttribute("logindto", loginDto);
				
				url = "MyProject.do?cmd=main";
				
			} else {
				request.setAttribute("login", "false");
				url = "MyProject.do?cmd=login";
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
		}
		
		
		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
