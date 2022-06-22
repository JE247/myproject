package kr.co.jhta.project.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ApprovalDAO;
import kr.co.jhta.project.dao.DocumentDAO;
import kr.co.jhta.project.dto.ApprovalDTO;
import kr.co.jhta.project.dto.DocumentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class WriteOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int eno = ((OfficeWorkerDTO)(req.getSession().getAttribute("logindto"))).getEno();
		String m = req.getParameter("meno");
		String t = req.getParameter("dtype");
		String contents = req.getParameter("contents");
		
		DocumentDTO dto = new DocumentDTO();
		
		dto.setEno(eno);
		dto.setDcontents(contents);
		dto.setDtype(Integer.parseInt(t));
		
		DocumentDAO dao = new DocumentDAO();
		dao.addOne(dto);

		int dcno = dao.findNum(eno);
		
		ApprovalDAO appdao = new ApprovalDAO();
		ApprovalDTO appdto = new ApprovalDTO();
		
		appdto.setDcno(dcno);
		appdto.setEno(Integer.parseInt(m));
		appdto.setReason("");
		
		appdao.addOne(appdto);

		return "MyProjectDoc.do?cmd=doc";
	}

}
