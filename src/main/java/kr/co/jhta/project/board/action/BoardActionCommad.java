package kr.co.jhta.project.board.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.BoardDAO;
import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.PagingSearch;

public class BoardActionCommad implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		try {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");

			String type = req.getParameter("type");
			String keyword = req.getParameter("keyword");

			BoardDAO dao = new BoardDAO();

			/* 페이징 처리하기 시작 */

			PagingSearch ps = new PagingSearch();

			ps.setType(type);
			ps.setKeyword(keyword);

			// 1. 총 게시물 수 구하기
			int total = dao.getTotalCount(ps);
			
			// 2. 현재 페이지 구하기
			int cp = 1;

			String cpg = req.getParameter("cp");
			if (cpg != null && !cpg.equals("")) {
				cp = Integer.parseInt(cpg);
			}

			// 3. 페이지 당 게시물 수
			int countPerPage = 10;

			// 4. 총 페이지 수
			int totalPage = (total % countPerPage == 0 ? total / countPerPage : total / countPerPage + 1);

			// 5. 현재 페이지 시작 번호
			int startNum = (cp - 1) * countPerPage + 1;

			// 6. 현재 페이지 끝 번호
			int endNum = cp * countPerPage;
			
			req.setAttribute("total", total);
			req.setAttribute("currentPage", cp);
			req.setAttribute("countPerPage", countPerPage);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("startNum", startNum);
			req.setAttribute("endNum", endNum);
			
			ps.setStartNum(startNum);
			ps.setEndNum(endNum);

			List<BoardDTO> list = dao.getAll(ps);

			req.setAttribute("boardlist", list);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "board/board.jsp";
	}

}
