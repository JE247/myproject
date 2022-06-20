package kr.co.jhta.project.callendar.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.CallendarDAO;
import kr.co.jhta.project.dto.CallendarDTO;

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

		CallendarDAO dao = new CallendarDAO();

		CallendarDTO dto = new CallendarDTO();
		
		dto.setEno(eno);
		dto.setTitle(title);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setLoc(loc);
		dto.setContents(contents);
		dto.setType(type);
		
		dao.addCal(dto);

		return "callendar/popupOk.jsp";
	}

}
