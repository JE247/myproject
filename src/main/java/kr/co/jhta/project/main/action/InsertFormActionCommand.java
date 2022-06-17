package kr.co.jhta.project.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.dao.DepartmentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.DepartmentDTO;

public class InsertFormActionCommand implements kr.co.jhta.project.controller.Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OfficeWorkerDAO odao = new OfficeWorkerDAO();
		DepartmentDAO ddao = new DepartmentDAO();
		
		List<String> positionlist = odao.getPosition();
		List<DepartmentDTO> deptlist = ddao.getAll();
		
		req.setAttribute("positionlist", positionlist);
		req.setAttribute("deptlist", deptlist);
		
		return "main/insertemp.jsp";
	}

}
