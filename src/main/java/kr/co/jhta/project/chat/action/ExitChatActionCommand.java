package kr.co.jhta.project.chat.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ChatPersonDAO;
import kr.co.jhta.project.dto.ChatPersonDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class ExitChatActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int chatno = Integer.parseInt(req.getParameter("chatno"));
		int eno = ((OfficeWorkerDTO)req.getSession().getAttribute("logindto")).getEno();
		
		ChatPersonDTO dto = new ChatPersonDTO();
		dto.setChatno(chatno);
		dto.setEno(eno);
		
		ChatPersonDAO dao = new ChatPersonDAO();
		dao.exit(dto);
		
		return "callendar/popupOk.jsp";
	}
}
