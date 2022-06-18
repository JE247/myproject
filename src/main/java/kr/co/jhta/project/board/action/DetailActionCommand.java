package kr.co.jhta.project.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.BoardDAO;
import kr.co.jhta.project.dao.FileDAO;
import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.FileDTO;

public class DetailActionCommand implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("bno");
		
		if(no != null) {
			int bno = Integer.parseInt(no);
			
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = dao.getOne(bno);
			
			FileDAO fdao = new FileDAO();
			List<FileDTO> list = fdao.getOne(bno);
			
			req.setAttribute("file", list);
			
			req.setAttribute("detaildto", dto);
		}
		
		return "board/detail.jsp";
	}

}
