package kr.co.jhta.project.doc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.DocumentDAO;
import kr.co.jhta.project.dto.DocumentDTO;

public class DeleteOneActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		String no = req.getParameter("dcno");

		if (no != null) {

			int dcno = Integer.parseInt(no);
			
			DocumentDAO dao = new DocumentDAO();
			dao.delete(dcno);
		}
		return "MyProjectDoc.do?cmd=doc";
	}

}
