package kr.co.jhta.project.chat.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.jhta.project.dao.ChatMessageDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.ChatMessageDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

@WebServlet("/ChatReceive.do")
public class ChatReceive extends HttpServlet {

	int eno;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		eno = ((OfficeWorkerDTO) req.getSession().getAttribute("logindto")).getEno();

		// 현재 채팅방 정보
		String cno = req.getParameter("chatno");
		String type = req.getParameter("type");

		if (type == null || type.equals("")) {
			resp.getWriter().write("");
		} else if (type.equals("today")) {
			resp.getWriter().write(getToday(Integer.parseInt(cno)));
		} else {
			resp.getWriter().write(getID(Integer.parseInt(cno), Integer.parseInt(type)));
		}

	}

	private String getID(int cno, int type) {

		ChatMessageDAO messageDao = new ChatMessageDAO();
		OfficeWorkerDAO officeDao = new OfficeWorkerDAO();

		ChatMessageDTO chatDto = new ChatMessageDTO();

		chatDto.setChatno(cno);
		chatDto.setMno(type);

		List<ChatMessageDTO> list = messageDao.realTime(chatDto);

		JSONArray chat = new JSONArray();

		if (list.size() > 0) {
			for (ChatMessageDTO dto : list) {

				JSONObject object = new JSONObject();

				int eNum = dto.getEno();
				String name = "";
				String img = officeDao.myInfo(eNum).getPhotoname();
				String picture = "";
				if (eno == eNum) {
					name = "나";
				} else {
					name = officeDao.myInfo(eNum).getName();
				}

				if (img == null) {
					picture = "basic.gif";
				} else {
					picture = img;
				}

				object.put("picture", img);
				object.put("name", name);
				object.put("date", dto.getMDate());
				object.put("msg", dto.getMessage());

				chat.add(object);
			}

			JSONObject finalList = new JSONObject();
			finalList.put("mno", list.get(list.size() - 1).getMno());

			chat.add(finalList);
		}
		return chat.toJSONString();
	}

	private String getToday(int cno) {

		ChatMessageDAO messageDao = new ChatMessageDAO();
		OfficeWorkerDAO officeDao = new OfficeWorkerDAO();

		List<ChatMessageDTO> list = messageDao.recentMessage(cno);

		JSONArray chat = new JSONArray();
		if (list.size() > 0) {
			for (ChatMessageDTO dto : list) {

				JSONObject object = new JSONObject();

				int eNum = dto.getEno();
				String name = "";
				String img = officeDao.myInfo(eNum).getPhotoname();
				String picture = "";
				if (eno == eNum) {
					name = "나";
				} else {
					name = officeDao.myInfo(eNum).getName();
				}

				if (img == null) {
					picture = "basic.gif";
				} else {
					picture = img;
				}

				object.put("picture", img);
				object.put("name", name);
				object.put("date", dto.getMDate());
				object.put("msg", dto.getMessage());

				chat.add(object);
			}

			JSONObject finalList = new JSONObject();
			finalList.put("mno", list.get(list.size() - 1).getMno());

			chat.add(finalList);
		}
		return chat.toJSONString();
	}

}
