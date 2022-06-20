package kr.co.jhta.project.callendar.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.CallendarDAO;
import kr.co.jhta.project.dto.CallendarDTO;
import kr.co.jhta.project.dto.DateEno;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class ModifyCalActioinCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();

		Object obj = session.getAttribute("logindto");
		
		String year = req.getParameter("year");
		
		String month = req.getParameter("month");
		
		if (obj != null) {
			OfficeWorkerDTO dto = (OfficeWorkerDTO) obj;

			CallendarDAO cdao = new CallendarDAO();
			List<CallendarDTO> list = null;
			
			if(year == null && month == null) {
				list = cdao.getMyCal(dto.getEno());
			} else {
				
				int mm = Integer.parseInt(month);
				
				if(mm < 10) {
					month = "0"+mm;
				}
				
				DateEno de = new DateEno(year, month, dto.getEno());
				list = cdao.getMyCalFilter(de);
				req.setAttribute("year", year);
				req.setAttribute("month", mm);
			}

			req.setAttribute("myList", list);
			

		}
		return "callendar/myCal.jsp";
	}

}
