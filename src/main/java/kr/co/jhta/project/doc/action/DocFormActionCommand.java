package kr.co.jhta.project.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.DocTypeDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.DocTypeDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class DocFormActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("logindto");
		
		if(obj != null) {
			OfficeWorkerDTO my = (OfficeWorkerDTO) obj;
			
			OfficeWorkerDAO odao = new OfficeWorkerDAO();
			OfficeWorkerDTO myInfo = odao.myInfo(my.getEno());
			req.setAttribute("my", myInfo);
			
		}
		
		int type = Integer.parseInt(req.getParameter("type"));
		
		DocTypeDAO ddao = new DocTypeDAO();
		DocTypeDTO ddto = ddao.getOne(type);
		
		req.setAttribute("dtype", ddto);
		
		return "doc/docForm.jsp";
	}
}
