package kr.co.jhta.project.reservation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.MeetingRoomDAO;
import kr.co.jhta.project.dto.MeetingRoomDTO;

public class AddRezFormActionCommad implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		MeetingRoomDAO dao = new MeetingRoomDAO();
		List<MeetingRoomDTO> list = dao.getAll();
		
		req.setAttribute("list", list);
		return "rez/addRezForm.jsp";
	}

}
