package kr.co.jhta.project.callendar.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.CallendarDAO;
import kr.co.jhta.project.dto.CallendarDTO;

public class UpdateOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no1 = req.getParameter("cno");
		String no2 = req.getParameter("eno");
		
		String title = req.getParameter("title");
		String startDate = req.getParameter("startdate");
		String endDate = req.getParameter("enddate");
		String loc = req.getParameter("loc");
		String contents = req.getParameter("contents");
		
		String t = req.getParameter("type");
		
		if(no1 != null && no2 != null && t != null) {
			
			int cno = Integer.parseInt(no1);
			int eno = Integer.parseInt(no2);
			int type = Integer.parseInt(t);
			
			CallendarDTO dto = new CallendarDTO(cno, eno, title, startDate, endDate, loc, contents, type);
			
			CallendarDAO dao = new CallendarDAO();
			dao.updateOk(dto);
		}
		
		return "callendar/popupOk.jsp";
	}
}
