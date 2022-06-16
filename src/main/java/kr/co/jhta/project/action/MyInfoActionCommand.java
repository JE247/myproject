package kr.co.jhta.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhta.project.dao.DepartmentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class MyInfoActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("logindto");
		
		if(obj != null) {
			OfficeWorkerDTO odto = (OfficeWorkerDTO) obj;
			OfficeWorkerDAO odao = new OfficeWorkerDAO();
			
			OfficeWorkerDTO myinfo = odao.myInfo(odto.getEno());
			
			DepartmentDAO ddao = new DepartmentDAO();
			DepartmentDTO mydept = ddao.getOne(myinfo.getDno());
			
			req.setAttribute("myinfo", myinfo);
			req.setAttribute("mydept", mydept);
			
		}
		return "main/myinfo.jsp";
	}

}
