package kr.co.jhta.project.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONObject;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ScrapDAO;
import kr.co.jhta.project.dto.EnoBnoDTO;
import kr.co.jhta.project.dto.ScrapDTO;

public class ScrapActionCommand {

	public JSONObject execute(HttpServletRequest req, HttpServletResponse resp) {
		String no1 = req.getParameter("eno");
		String no2 = req.getParameter("bno");
		String s = req.getParameter("scrap");
		
		boolean flag = false;
		
		if(s.equals("true")) {
			flag = true;
		}
		
		if(no1 != null && no2 != null) {
			int eno = Integer.parseInt(no1);
			int bno = Integer.parseInt(no2);
			
			ScrapDAO sdao = new ScrapDAO();
			EnoBnoDTO dto = new EnoBnoDTO(eno, bno);
			
			if(flag) {
				sdao.scrapRemove(dto);
			} else {
				sdao.scrapAdd(dto);
			}
		}
		
		JSONObject obj = new JSONObject();
		obj.put("scrap", flag);
		
		try {
			resp.setContentType("application/x-json; charset=UTF-8");
			resp.getWriter().print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return obj;
	}

}
