package kr.co.jhta.project.calendar.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.CalendarDAO;
import kr.co.jhta.project.dto.CalendarDTO;

public class DeleteActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("cno");
		if(no != null) {
			
			int cno = Integer.parseInt(no);
			
			CalendarDAO dao = new CalendarDAO();
			dao.deleteOne(cno);
		}
		return "calendar/popupOk.jsp";
	}
}
