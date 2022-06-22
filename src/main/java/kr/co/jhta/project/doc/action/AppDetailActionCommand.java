package kr.co.jhta.project.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.DocTypeDAO;
import kr.co.jhta.project.dao.DocumentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.DocumentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class AppDetailActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("dcno");
		
		DocumentDAO dao = new DocumentDAO();
		DocumentDTO dto = dao.getOne(Integer.parseInt(no));
		
		DocTypeDAO tdao = new DocTypeDAO();
		String title = tdao.getOne(dto.getDtype()).getDtitle();
		
		String myName = ((OfficeWorkerDTO)req.getSession().getAttribute("logindto")).getName();
		
		
		OfficeWorkerDAO odao = new OfficeWorkerDAO();
		String name = odao.myInfo(dto.getEno()).getName();
		
		req.setAttribute("title", title);
		req.setAttribute("name", name);
		req.setAttribute("myName", myName);
		req.setAttribute("detail", dto);
		
		return "doc/appdetail.jsp";
	}

}
