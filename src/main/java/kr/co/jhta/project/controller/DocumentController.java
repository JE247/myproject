package kr.co.jhta.project.controller;

import java.io.IOException;

import javax.print.DocPrintJob;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.doc.action.AppDetailActionCommand;
import kr.co.jhta.project.doc.action.AppOkActionCommand;
import kr.co.jhta.project.doc.action.DeleteOneActionCommand;
import kr.co.jhta.project.doc.action.DocActionCommand;
import kr.co.jhta.project.doc.action.DocDetailActionCommand;
import kr.co.jhta.project.doc.action.DocFormActionCommand;
import kr.co.jhta.project.doc.action.ManagerActionCommand;
import kr.co.jhta.project.doc.action.WriteOkActionCommand;

@WebServlet("/MyProjectDoc.do")
public class DocumentController extends HttpServlet {

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		Action ac = null;
		
		String url = "";
		
		String cmd = req.getParameter("cmd");
		
		if(cmd == null || cmd.equals("doc")) {
			ac = new DocActionCommand();
		} else if(cmd.equals("docForm")) {
			ac = new DocFormActionCommand();
		} else if(cmd.equals("myManager")) {
			ac = new ManagerActionCommand();
		} else if(cmd.equals("writeOk")) {
			ac = new WriteOkActionCommand();
		} else if(cmd.equals("appDetail")) {
			ac = new AppDetailActionCommand();
		} else if(cmd.equals("appOk")) {
			ac = new AppOkActionCommand();
		} else if(cmd.equals("docDetail")) {
			ac = new DocDetailActionCommand();
		} else if(cmd.equals("delete")) {
			ac = new DeleteOneActionCommand();
		}
		
		url = ac.execute(req, resp);
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
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
