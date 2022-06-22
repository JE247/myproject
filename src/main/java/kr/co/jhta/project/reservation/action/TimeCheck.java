package kr.co.jhta.project.reservation.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.dao.ReservationDAO;
import kr.co.jhta.project.dto.ReservationDTO;

@WebServlet("/TimeCheck.do")
public class TimeCheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String sTime = req.getParameter("startTime");
		String eTime = req.getParameter("endTime");
		String rno = req.getParameter("roomno");
		String rezDate = req.getParameter("rezDate");
		
		if(sTime != null && eTime != null && rno != null) {
			int startTime = Integer.parseInt(sTime);
			int endTime = Integer.parseInt(eTime);
			int roomNo = Integer.parseInt(rno);
			
			ReservationDAO dao = new ReservationDAO();
			ReservationDTO dto = new ReservationDTO();
			
			dto.setRoomNo(roomNo);
			dto.setRezDate(rezDate);
			dto.setStartTime(startTime);
			dto.setEndTime(endTime);
			
			boolean check = dao.timeCheck(dto);
			
			if(check) {
				resp.getWriter().write("1");
			} else {
				resp.getWriter().write("0");
			}
		}
	}
}
