package kr.co.jhta.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class MainActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("logindto");
		
		if(obj!=null) {
			OfficeWorkerDTO dto = (OfficeWorkerDTO)obj;
			
			OfficeWorkerDAO dao = new OfficeWorkerDAO();
			OfficeWorkerDTO maindto = dao.myInfo(dto.getEno());
			
			req.setAttribute("maindto", maindto);
			
		}
		return "main/main.jsp";
	}

}
