package kr.co.jhta.project.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.board.action.BoardActionCommad;
import kr.co.jhta.project.main.action.AllEmpActionCommand;
import kr.co.jhta.project.main.action.DeleteOkActionCommand;
import kr.co.jhta.project.main.action.EditEmpActionCommand;
import kr.co.jhta.project.main.action.EditOkActionCommand;
import kr.co.jhta.project.main.action.InsertEmpActionCommand;
import kr.co.jhta.project.main.action.InsertFormActionCommand;
import kr.co.jhta.project.main.action.LoginActionCommend;
import kr.co.jhta.project.main.action.LoginFormActionCommand;
import kr.co.jhta.project.main.action.LogoutActionCommand;
import kr.co.jhta.project.main.action.MainActionCommand;
import kr.co.jhta.project.main.action.MyInfoActionCommand;
import kr.co.jhta.project.main.action.MyInfoOkActionCommand;

@WebServlet("/MyProjectBoard.do")
public class BoardController extends HttpServlet {
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Action ac = null;
		
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			
			String cmd = req.getParameter("cmd");
			String url = "";
			
			if(cmd==null || cmd.equals("board")) {
				ac = new BoardActionCommad();
			}
			
			
			url = ac.execute(req, resp);

			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
