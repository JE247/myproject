package kr.co.jhta.project.reservation.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.MeetingRoomDAO;
import kr.co.jhta.project.dao.ReservationDAO;
import kr.co.jhta.project.dto.MeetingRoomDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;
import kr.co.jhta.project.dto.ReservationDTO;

public class RezActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("logindto");
		
		int eno = 0;
		
		if(obj != null) {
			eno = ((OfficeWorkerDTO)obj).getEno();
		}
		
		String today = req.getParameter("selectDate");

		String day = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
		
		if(today == null) {
			today = day;
		}

		/* 회의실 목록 가져오기 */
		MeetingRoomDAO mdao = new MeetingRoomDAO();
		List<MeetingRoomDTO> roomList = mdao.getAll();
		req.setAttribute("roomList", roomList);

		/* 회의실 현황 가져오기 */
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<List> rezAll = new ArrayList<List>();

		for (int i = 1; i <= 4; i++) {
			ReservationDTO dto = new ReservationDTO();
			dto.setRezDate(today);
			dto.setRoomNo(i);
			List<ReservationDTO> rezList = rdao.todayOneRez(dto);
			req.setAttribute("rezList"+i, rezList);
			rezAll.add(rezList);
		}
		req.setAttribute("rezAll", rezAll);
		req.setAttribute("today", today);
		
		/* 내 예약정보 가져오기 */
		
		List<ReservationDTO> myrez = rdao.myRez(eno);
		req.setAttribute("myRez", myrez);
		
		return "rez/reservation.jsp";
	}

}
