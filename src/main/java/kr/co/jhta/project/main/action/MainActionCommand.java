package kr.co.jhta.project.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.BoardDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;
import kr.co.jhta.project.dto.PagingSearch;

public class MainActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("logindto");

		if (obj != null) {
			OfficeWorkerDTO dto = (OfficeWorkerDTO) obj;

			OfficeWorkerDAO dao = new OfficeWorkerDAO();
			OfficeWorkerDTO maindto = dao.myInfo(dto.getEno());

			BoardDAO bdao = new BoardDAO();

			PagingSearch ps = new PagingSearch();

			ps.setStartNum(1);
			ps.setEndNum(10);

			List<BoardDTO> list = bdao.getAll(ps);
			List<BoardDTO> scrap = bdao.scrapList(maindto.getEno());

			req.setAttribute("maindto", maindto);
			req.setAttribute("board", list);
			req.setAttribute("scrap", scrap);

		}
		return "main/main.jsp";
	}

}
