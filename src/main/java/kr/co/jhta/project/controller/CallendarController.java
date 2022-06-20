package kr.co.jhta.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.callendar.action.AddCalActionCommand;
import kr.co.jhta.project.callendar.action.AddOkActionCommad;
import kr.co.jhta.project.callendar.action.CallendarActionCommand;
import kr.co.jhta.project.callendar.action.DeleteActionCommand;
import kr.co.jhta.project.callendar.action.ModifyCalActioinCommand;
import kr.co.jhta.project.callendar.action.ModifyFormActionCommand;
import kr.co.jhta.project.callendar.action.UpdateOkActionCommand;

@WebServlet("/MyProjectCallendar.do")
public class CallendarController extends HttpServlet {
	
	Action ac = null;

	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String cmd = req.getParameter("cmd");
		String url = "";
		
		if(cmd == null || cmd.equals("cal")) {
			ac = new CallendarActionCommand();
		} else if(cmd.equals("addCal")) {
			ac = new AddCalActionCommand();
		} else if(cmd.equals("addCalOk")) {
			ac = new AddOkActionCommad();
		} else if(cmd.equals("modifyCal")) {
			ac = new ModifyCalActioinCommand();
		} else if(cmd.equals("modifyCalForm")) {
			ac = new ModifyFormActionCommand();
		} else if(cmd.equals("updateOk")) {
			ac = new UpdateOkActionCommand();
		} else if(cmd.equals("deleteOne")) {
			ac = new DeleteActionCommand();
		}
		
		url = ac.execute(req, resp);
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
