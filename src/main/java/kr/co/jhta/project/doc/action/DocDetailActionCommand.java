package kr.co.jhta.project.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ApprovalDAO;
import kr.co.jhta.project.dao.DocTypeDAO;
import kr.co.jhta.project.dao.DocumentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.ApprovalDTO;
import kr.co.jhta.project.dto.DocumentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class DocDetailActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int dno = Integer.parseInt(req.getParameter("dcno"));
		
		
		DocTypeDAO ddao = new DocTypeDAO();
		DocumentDAO dao = new DocumentDAO();
		ApprovalDAO ado = new ApprovalDAO();
		OfficeWorkerDAO odao = new OfficeWorkerDAO();
		
		DocumentDTO dto = dao.getOne(dno);
		
		String manager = odao.myInfo(ado.getOne(dno).getEno()).getName();
		String dtitle = ddao.getOne(dto.getDtype()).getDtitle();
		String myname = odao.myInfo(((OfficeWorkerDTO)req.getSession().getAttribute("logindto")).getEno()).getName();
		
		req.setAttribute("dto", dto);
		req.setAttribute("manager", manager);
		req.setAttribute("myname", myname);
		req.setAttribute("dtitle", dtitle);
		return "doc/docDetail.jsp";
	}
}
