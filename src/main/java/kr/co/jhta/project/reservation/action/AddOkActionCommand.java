package kr.co.jhta.project.reservation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ReservationDAO;
import kr.co.jhta.project.dto.ReservationDTO;

public class AddOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String rno = req.getParameter("roomno");
		String rezDate = req.getParameter("rezDate");
		String sTime = req.getParameter("startTime");
		String eTime = req.getParameter("endTime");
		String p = req.getParameter("people");
		String memo = req.getParameter("memo");
		String e = req.getParameter("eno");
		
		if(sTime != null && eTime != null && rno != null && p != null && e != null) {
			int startTime = Integer.parseInt(sTime);
			int endTime = Integer.parseInt(eTime);
			int roomNo = Integer.parseInt(rno);
			int people = Integer.parseInt(p);
			int eno = Integer.parseInt(e);
			
			ReservationDAO dao = new ReservationDAO();
			ReservationDTO dto = new ReservationDTO();
			
			dto.setRoomNo(roomNo);
			dto.setRezDate(rezDate);
			dto.setStartTime(startTime);
			dto.setEndTime(endTime);
			dto.setPeople(people);
			dto.setMemo(memo);
			dto.setEno(eno);
			
			dao.addRez(dto);
			
		}
		return "callendar/popupOk.jsp";
	}
}
