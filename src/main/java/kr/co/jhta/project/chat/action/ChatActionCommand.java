package kr.co.jhta.project.chat.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ChatDAO;
import kr.co.jhta.project.dao.ChatMessageDAO;
import kr.co.jhta.project.dao.ChatPersonDAO;
import kr.co.jhta.project.dao.ChatStatusDAO;
import kr.co.jhta.project.dto.ChatDTO;
import kr.co.jhta.project.dto.ChatMain;
import kr.co.jhta.project.dto.ChatMessageDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class ChatActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		int eno = ((OfficeWorkerDTO) req.getSession().getAttribute("logindto")).getEno();

		/* 나의 채팅 리스트 만들기 */

		ChatDAO chatDao = new ChatDAO();
		ChatPersonDAO personDao = new ChatPersonDAO();
		ChatMessageDAO messageDao = new ChatMessageDAO();
		ChatStatusDAO statusDao = new ChatStatusDAO();

		List<ChatDTO> chatList = chatDao.myChat(eno);
		List<ChatMain> chatMain = new ArrayList<ChatMain>();

		if (chatList != null) {
			
			for (ChatDTO dto : chatList) {
				

				int cno = dto.getCno();
				int person = personDao.countPerson(cno);

				ChatMessageDTO info = new ChatMessageDTO();
				
				info.setChatno(cno);
				info.setEno(eno);
				
				int noread = statusDao.noRead(info);
				
				String chatName = dto.getChatName();

				String chatMessage = "메세지가 존재하지 않습니다.";
				String chatTime = "";

				if (messageDao.finalMessage(cno) != null) {
					chatMessage = messageDao.finalMessage(cno).getMessage();
					chatTime = messageDao.finalMessage(cno).getMDate();
				}
				
				ChatMain chat = new ChatMain(cno, person, noread, chatName, chatMessage, chatTime);
				chatMain.add(chat);
			}
		}
		
		req.setAttribute("chatMain", chatMain);

		return "chat/chat.jsp";
	}

}
