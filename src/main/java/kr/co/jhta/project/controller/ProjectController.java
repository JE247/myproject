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

import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;
import kr.co.jhta.project.main.action.AllEmpActionCommand;
import kr.co.jhta.project.main.action.DeleteOkActionCommand;
import kr.co.jhta.project.main.action.EditEmpActionCommand;
import kr.co.jhta.project.main.action.MyInfoOkActionCommand;
import kr.co.jhta.project.main.action.EditOkActionCommand;
import kr.co.jhta.project.main.action.InsertEmpActionCommand;
import kr.co.jhta.project.main.action.InsertFormActionCommand;
import kr.co.jhta.project.main.action.LoginActionCommend;
import kr.co.jhta.project.main.action.LoginFormActionCommand;
import kr.co.jhta.project.main.action.LogoutActionCommand;
import kr.co.jhta.project.main.action.MainActionCommand;
import kr.co.jhta.project.main.action.MyInfoActionCommand;

@WebServlet("/MyProject.do")
public class ProjectController extends HttpServlet {

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Action ac = null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			String cmd = request.getParameter("cmd");
			String url = "";
			
			if(cmd == null || cmd.equals("login")) {
				ac = new LoginActionCommend();
			} else if (cmd.equals("loginForm")) {
				ac = new LoginFormActionCommand();
			} else if (cmd.equals("logout")) {
				ac = new LogoutActionCommand();
			} else if (cmd.equals("main")) {
				ac = new MainActionCommand();
			} else if (cmd.equals("myinfo")) {
				ac = new MyInfoActionCommand();
			}  else if (cmd.equals("infoeditOk")) {
				ac = new MyInfoOkActionCommand();
			} else if (cmd.equals("allemp")) {
				ac = new AllEmpActionCommand();
			} else if (cmd.equals("editemp")) {
				ac = new EditEmpActionCommand();
			} else if (cmd.equals("insertemp")) {
				ac = new InsertFormActionCommand();
			} else if (cmd.equals("insertOk")) {
				ac = new InsertEmpActionCommand();
			} else if (cmd.equals("editOk")) {
				ac = new EditOkActionCommand();
			} else if (cmd.equals("deleteemp")) {
				ac = new DeleteOkActionCommand();
			}
			
			url = ac.execute(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

			
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
