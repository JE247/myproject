package kr.co.jhta.project.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.DepartmentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class EditEmpActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("selectone");
		
		if (no != null) {
			
			int eno = Integer.parseInt(no);
			
			OfficeWorkerDAO odao = new OfficeWorkerDAO();
			DepartmentDAO ddao = new DepartmentDAO();
			
			OfficeWorkerDTO infodto = odao.myInfo(eno);
			
			List<DepartmentDTO> deptlist = ddao.getAll();
			List<String> rankposition = odao.getPosition();
			
			req.setAttribute("infodto", infodto);
			req.setAttribute("deptlist", deptlist);
			req.setAttribute("rankposition", rankposition);
		}
		
		
		return "main/editemp.jsp";
	}

}
