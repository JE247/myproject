package kr.co.jhta.project.chat.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.dao.ChatMessageDAO;
import kr.co.jhta.project.dao.ChatPersonDAO;
import kr.co.jhta.project.dao.ChatStatusDAO;
import kr.co.jhta.project.dto.ChatMessageDTO;
import kr.co.jhta.project.dto.ChatPersonDTO;
import kr.co.jhta.project.dto.ChatStatusDTO;

@WebServlet("/ChatSend.do")
public class ChatSend extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String cno = req.getParameter("chatno");
		String e = req.getParameter("eno");
		String msg = req.getParameter("message");
		
		ChatMessageDAO msgDao = new ChatMessageDAO();
		ChatPersonDAO personDao = new ChatPersonDAO();
		ChatStatusDAO statusDao = new ChatStatusDAO();
		
		/* DB에 메시지 입력하기 */
		
		if(cno != null && !cno.equals("") && e != null && !e.equals("")) {
			
			int chatno = Integer.parseInt(cno);
			int eno = Integer.parseInt(e);
			
			ChatMessageDTO dto = new ChatMessageDTO();
			
			dto.setChatno(chatno);
			dto.setEno(eno);
			dto.setMessage(msg);
			
			msgDao.addMessage(dto);
			
			/* 상태 정보 저장하기 */
			
			int num = msgDao.findNo(dto);
			
			List<ChatPersonDTO> list = personDao.findPerson(dto);
			
			for(ChatPersonDTO personDto : list) {
				
				ChatStatusDTO statusDto = new ChatStatusDTO();
				
				statusDto.setEno(personDto.getEno());
				statusDto.setMno(num);
				statusDto.setStatus(1);
				
				statusDao.addStatus(statusDto);
			}
		}

		resp.getWriter().write("성공");

	}
}
