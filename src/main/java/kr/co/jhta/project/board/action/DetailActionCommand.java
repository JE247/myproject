package kr.co.jhta.project.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.BoardDAO;
import kr.co.jhta.project.dao.FileDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dao.ScrapDAO;
import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.EnoBnoDTO;
import kr.co.jhta.project.dto.FileDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;
import kr.co.jhta.project.dto.ScrapDTO;

public class DetailActionCommand implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("bno");
		int eno = ((OfficeWorkerDTO)(req.getSession().getAttribute("logindto"))).getEno();
		
		if(no != null) {
			String name = (new OfficeWorkerDAO()).myInfo(eno).getName();
			int bno = Integer.parseInt(no);
			
			BoardDAO dao = new BoardDAO();
			dao.hitsAdd(bno);
			
			ScrapDAO sdao = new ScrapDAO();
			EnoBnoDTO ebno = new EnoBnoDTO(eno, bno);
			
			ScrapDTO sdto = sdao.findScrap(ebno);
			
			boolean scrap = false;
			
			if(sdto != null) {
				scrap = true;
			}

			BoardDTO dto = dao.getOne(bno);
			
			boolean my = false;
			
			if(dto.getWriter().equals(name)) {
				my = true;
			}
			
			FileDAO fdao = new FileDAO();
			List<FileDTO> list = fdao.getOne(bno);
			
			req.setAttribute("scrap", scrap);
			if(list.size() > 0) {
				req.setAttribute("file", list);
			}
			req.setAttribute("detaildto", dto);
			req.setAttribute("my", my);
		}
		
		return "board/detail.jsp";
	}

}
