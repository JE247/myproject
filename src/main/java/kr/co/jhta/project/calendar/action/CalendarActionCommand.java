package kr.co.jhta.project.calendar.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.CalendarDAO;
import kr.co.jhta.project.dto.CalendarDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class CalendarActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("logindto");
		
		if(obj != null) {
			OfficeWorkerDTO dto = (OfficeWorkerDTO)obj;
			
			CalendarDAO cdao = new CalendarDAO();
			List<CalendarDTO> list = cdao.getMyCal(dto.getEno());
			
			JSONArray array = new JSONArray();
			
			for(CalendarDTO cdto : list) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("title", cdto.getTitle());
				jsonObj.put("start", cdto.getStartDate());
				jsonObj.put("end", cdto.getEndDate()+"T24:00:00");
				
				String color = "";
				
				if(cdto.getType() ==  1) {
					color = "#257e4a";
				} else {
					color = "#316CF4";
				}
				jsonObj.put("color", color);
				array.add(jsonObj);
			}
			
			req.setAttribute("myList", array.toJSONString());
			
		}
		
		return "calendar/calendar.jsp";
	}

}
