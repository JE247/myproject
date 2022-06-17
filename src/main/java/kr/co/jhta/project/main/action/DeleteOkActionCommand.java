package kr.co.jhta.project.main.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.OfficeWorkerDAO;

public class DeleteOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String no = req.getParameter("selectone");
		
		if(no != null) {
			int eno = Integer.parseInt(no);
			
			OfficeWorkerDAO dao = new OfficeWorkerDAO();
			dao.deleteEmp(eno);
		}
		return "MyProject.do?cmd=allemp";
	}

}
