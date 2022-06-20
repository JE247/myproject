package kr.co.jhta.project.callendar.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.CallendarDAO;
import kr.co.jhta.project.dto.CallendarDTO;

public class ModifyFormActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("cno");
		if(no != null) {
			int cno = Integer.parseInt(no);
			
			CallendarDAO dao = new CallendarDAO();
			CallendarDTO dto = dao.getOne(cno);
			
			req.setAttribute("cal", dto);
		}
		return "callendar/updateForm.jsp";
	}

}
