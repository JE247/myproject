package kr.co.jhta.project.doc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class ManagerActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		OfficeWorkerDAO odao = new OfficeWorkerDAO();
		List<OfficeWorkerDTO> list = odao.myManager();
		
		req.setAttribute("list", list);
		return "doc/manager.jsp";
	}
}
