package kr.co.jhta.project.chat.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.jhta.project.controller.Action;

@WebServlet("/MyProjectChatAjax.do")
public class AjaxTest extends HttpServlet{

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONArray array = new JSONArray();
		for(int i=0; i<3; i++) {
			JSONObject obj = new JSONObject();
			obj.put("send", "send"+i);
			obj.put("cont", "cont"+i);
			array.add(obj);
		}
		
		JSONObject obj1 = new JSONObject();
		
		obj1.put("last", "last");
		array.add(obj1);
		
		resp.getWriter().write(array.toJSONString());
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
