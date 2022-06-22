package kr.co.jhta.project.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ApprovalDAO;
import kr.co.jhta.project.dto.ApprovalDTO;

public class AppOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int dcno = Integer.parseInt(req.getParameter("dcno"));

		int status = Integer.parseInt(req.getParameter("status"));
		String reason = req.getParameter("reason");
		
		ApprovalDAO dao = new ApprovalDAO();
		ApprovalDTO dto = new ApprovalDTO();
		
		dto.setDcno(dcno);
		dto.setStatus(status);
		dto.setReason(reason);
		
		dao.appOne(dto);
		
		return "MyProjectDoc.do?cmd=doc";
	}

}
