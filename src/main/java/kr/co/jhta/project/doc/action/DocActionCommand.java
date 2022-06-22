package kr.co.jhta.project.doc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.ApprovalDAO;
import kr.co.jhta.project.dao.DocTypeDAO;
import kr.co.jhta.project.dao.DocumentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.AppList;
import kr.co.jhta.project.dto.ApprovalDTO;
import kr.co.jhta.project.dto.DocList;
import kr.co.jhta.project.dto.DocTypeDTO;
import kr.co.jhta.project.dto.DocumentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class DocActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		DocTypeDAO docDao = new DocTypeDAO();
		DocumentDAO ddao = new DocumentDAO();
		ApprovalDAO ado = new ApprovalDAO();
		OfficeWorkerDAO officeDao = new OfficeWorkerDAO();
		
		int eno = ((OfficeWorkerDTO)(req.getSession().getAttribute("logindto"))).getEno();		

		String s = req.getParameter("status");
		
		List<DocumentDTO> mydocList = null;
		
		if(s == null || s.equals("")) {
			mydocList = ddao.myList(eno);
		} else {
			int status = Integer.parseInt(s);
			
			ApprovalDTO dto = new ApprovalDTO();
			dto.setEno(eno);
			dto.setStatus(status);
			
			mydocList = ddao.myListFilter(dto);
			req.setAttribute("status", status);
		}
		
		List<DocTypeDTO> list = docDao.getAll();
		
		
		ArrayList<DocList> myList = new ArrayList<DocList>();
		
		/* 나의 신청 내역 */
		
		for(DocumentDTO dto : mydocList) {
			
			DocList dc = new DocList();
			
			dc.setDcno(dto.getDcno());
			dc.setStauts(ado.getOne(dto.getDcno()).getStatus());
			dc.setDtitle(docDao.getOne(dto.getDtype()).getDtitle());
			dc.setManager(officeDao.myInfo(ado.getOne(dto.getDcno()).getEno()).getName());
			dc.setAppDate(ado.getOne(dto.getDcno()).getAppdate());
			
			myList.add(dc);
		}
		
		/* 결제 처리해줄 내역 */

		List<ApprovalDTO> appList = ado.appList(eno);
		ArrayList<AppList> docList = new ArrayList<AppList>();
		
		for(ApprovalDTO dto : appList) {
			
			AppList doc = new AppList();
			
			doc.setDcno(dto.getDcno());
			doc.setDtitle(docDao.getOne(ddao.getOne(dto.getDcno()).getDtype()).getDtitle());
			doc.setEno(ddao.getOne(dto.getDcno()).getEno());
			doc.setName(officeDao.myInfo(ddao.getOne(dto.getDcno()).getEno()).getName());
			doc.setRegdate(ddao.getOne(dto.getDcno()).getDregdate());
			
			docList.add(doc);
		}
		req.setAttribute("myList", myList);
		req.setAttribute("docList", docList);
		req.setAttribute("docAll", list);
		return "doc/document.jsp";
	}

}
