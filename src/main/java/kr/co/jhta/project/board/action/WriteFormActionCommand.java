package kr.co.jhta.project.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class WriteFormActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		OfficeWorkerDTO dto = (OfficeWorkerDTO)session.getAttribute("logindto");
		
		OfficeWorkerDAO dao = new OfficeWorkerDAO();
		OfficeWorkerDTO myinfo = dao.myInfo(dto.getEno());
		
		req.setAttribute("myinfo", myinfo);
		
		return "board/writeform.jsp";
	}

}
