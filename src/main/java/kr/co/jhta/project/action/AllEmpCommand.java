package kr.co.jhta.project.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.dao.DepartmentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class AllEmpCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OfficeWorkerDAO odao = new OfficeWorkerDAO();
		DepartmentDAO ddao = new DepartmentDAO();
		
		String dno = req.getParameter("dname");
		
		int no = 0;
		
		if(dno == null || dno.equals("")) {
			no = 0;
		} else {
			no = Integer.parseInt(dno);
			
			String dname = ddao.getOne(no).getDname();
			req.setAttribute("dname", dname);
		}
		String rank = req.getParameter("rank");
		
		OfficeWorkerDTO dto = new OfficeWorkerDTO();
		
		dto.setDno(no);
		dto.setPosition(rank);
		
		List<OfficeWorkerDTO> emplist = null;
		
		if((rank == null && dno == null)||(rank.equals("")&&dno.equals(""))) {
			emplist = odao.getAll();
		} else {
			emplist = odao.getFilter(dto);
		}
		
		List<String> positionlist = odao.getPosition();
		List<DepartmentDTO> deptlist = ddao.getAll();
		
		req.setAttribute("emplist", emplist);
		req.setAttribute("deptlist", deptlist);
		req.setAttribute("positionlist", positionlist);
		
		req.setAttribute("rank", rank);
		
		return "main/allemp.jsp";
	}

}
