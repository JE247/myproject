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

import kr.co.jhta.project.board.action.ScrapActionCommand;
import kr.co.jhta.project.chat.action.AddChatRoomActionCommad;
import kr.co.jhta.project.chat.action.AddRoomOkActionCommand;
import kr.co.jhta.project.chat.action.AjaxTest;
import kr.co.jhta.project.chat.action.ChatActionCommand;
import kr.co.jhta.project.chat.action.ChatInterActionCommand;
import kr.co.jhta.project.chat.action.ExitChatActionCommand;

@WebServlet("/MyProjectChatting.do")
public class ChattingController extends HttpServlet {
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Action ac = null;
		
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			
			String cmd = req.getParameter("cmd");
			String url = "";
			
			if(cmd==null || cmd.equals("chat")) {
				ac = new ChatActionCommand();
			} else if(cmd.equals("addChatRoom")) {
				ac = new AddChatRoomActionCommad();
			} else if(cmd.equals("addOk")) {
				ac = new AddRoomOkActionCommand();
			} else if(cmd.equals("chatInter")) {
				ac = new ChatInterActionCommand();
			} else if(cmd.equals("exitchat")) {
				ac = new ExitChatActionCommand();
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
