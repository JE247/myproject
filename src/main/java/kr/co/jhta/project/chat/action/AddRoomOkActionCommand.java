package kr.co.jhta.project.chat.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ChatDAO;
import kr.co.jhta.project.dao.ChatPersonDAO;
import kr.co.jhta.project.dto.ChatDTO;
import kr.co.jhta.project.dto.ChatPersonDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class AddRoomOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int eno = ((OfficeWorkerDTO)req.getSession().getAttribute("logindto")).getEno();
		
		String[] m = req.getParameterValues("eno");
		String chatName = req.getParameter("room");
		
		ChatDAO chatDao = new ChatDAO();
		ChatDTO chatDto = new ChatDTO(0, chatName, eno);
		
		chatDao.addChat(chatDto);
		
		/* 사람 추가 */
		
		int chatno = chatDao.findNo(eno);
		
		ChatPersonDAO cpDao = new ChatPersonDAO();
		ChatPersonDTO cpDto = new ChatPersonDTO(0, eno, chatno);
		cpDao.addPerson(cpDto);
		
		for(String e : m) {
			if(e != null && !e.equals("")) {
				
				int member = Integer.parseInt(e);
				ChatPersonDTO cdto = new ChatPersonDTO(0, member, chatno);
				
				cpDao.addPerson(cdto);
			}
		}
		
		return "callendar/popupOk.jsp";
	}

}
