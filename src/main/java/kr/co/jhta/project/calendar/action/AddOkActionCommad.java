package kr.co.jhta.project.calendar.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.CalendarDAO;
import kr.co.jhta.project.dto.CalendarDTO;

public class AddOkActionCommad implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		String no = req.getParameter("eno");
		String t = req.getParameter("type");

		int eno = 0;
		int type = 0;
		if (no != null && t != null) {
			eno = Integer.parseInt(no);
			type = Integer.parseInt(t);
		}
		String title = req.getParameter("title");
		String startDate = req.getParameter("startdate");
		String endDate = req.getParameter("enddate");
		String loc = req.getParameter("loc");
		String contents = req.getParameter("contents");

		CalendarDAO dao = new CalendarDAO();

		CalendarDTO dto = new CalendarDTO();
		
		dto.setEno(eno);
		dto.setTitle(title);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setLoc(loc);
		dto.setContents(contents);
		dto.setType(type);
		
		dao.addCal(dto);

		return "calendar/popupOk.jsp";
	}

}
