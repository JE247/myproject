package kr.co.jhta.project.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.BoardDAO;

public class DeleteActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String no = req.getParameter("bno");
		
		System.out.println("액션호출");
		
		if(no != null) {
			
			int bno = Integer.parseInt(no);
			
			BoardDAO dao = new BoardDAO();
			dao.deleteOne(bno);
		}
		
		
		
		return "MyProjectBoard.do?cmd=board";
	}

}
