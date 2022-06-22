package kr.co.jhta.project.reservation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.MeetingRoomDAO;
import kr.co.jhta.project.dao.ReservationDAO;
import kr.co.jhta.project.dto.MeetingRoomDTO;
import kr.co.jhta.project.dto.ReservationDTO;

public class DeleteActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String rno = req.getParameter("rno");
		
		if(rno != null) {
			
			int rezNo = Integer.parseInt(rno);
			
			ReservationDAO dao = new ReservationDAO();
			dao.deleteOne(rezNo);
			
		}
		
		return "MyProjectRez.do?cmd=rez";
	}
}
