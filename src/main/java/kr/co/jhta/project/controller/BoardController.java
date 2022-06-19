package kr.co.jhta.project.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.jhta.project.board.action.BoardActionCommad;
import kr.co.jhta.project.board.action.DeleteActionCommand;
import kr.co.jhta.project.board.action.DetailActionCommand;
import kr.co.jhta.project.board.action.DownloadActionCommad;
import kr.co.jhta.project.board.action.ModifyFormActionCommad;
import kr.co.jhta.project.board.action.ModifyOkActionCommad;
import kr.co.jhta.project.board.action.ScrapActionCommand;
import kr.co.jhta.project.board.action.WriteFormActionCommand;
import kr.co.jhta.project.board.action.WriteOkActionCommand;

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
			} else if(cmd.equals("detail")) {
				ac = new DetailActionCommand();
			} else if(cmd.equals("download")) {
				ac = new DownloadActionCommad();
				url = ac.execute(req, resp);
				return;
			} else if(cmd.equals("write")){
				ac = new WriteFormActionCommand();
			} else if(cmd.equals("writeOk")) {
				ac = new WriteOkActionCommand();
			} else if(cmd.equals("scrap")) {
				JSONObject obj = new ScrapActionCommand().execute(req, resp);
				return;
			} else if(cmd.equals("modify")) {
				ac = new ModifyFormActionCommad();
			} else if(cmd.equals("modifyOk")) {
				ac = new ModifyOkActionCommad();
			} else if(cmd.equals("delete")) {
				ac = new DeleteActionCommand();
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
