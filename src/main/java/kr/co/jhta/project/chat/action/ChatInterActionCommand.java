package kr.co.jhta.project.chat.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ChatStatusDAO;
import kr.co.jhta.project.dto.ChatMessageDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class ChatInterActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String cno = req.getParameter("cno");
		
		if(cno != null && !cno.equals("")) {
			int chatno = Integer.parseInt(cno);
			int eno = ((OfficeWorkerDTO) req.getSession().getAttribute("logindto")).getEno();
			
			ChatStatusDAO statusDao = new ChatStatusDAO();
			
			ChatMessageDTO info = new ChatMessageDTO();
			
			info.setChatno(chatno);
			info.setEno(eno);
			
			statusDao.readAll(info);
			
			req.setAttribute("chatno", chatno);
		}
		return "chat/chatting.jsp";
	}

}