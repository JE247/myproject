package kr.co.jhta.project.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.BoardDAO;
import kr.co.jhta.project.dao.CallendarDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.CallendarDTO;
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
			
			CallendarDAO cdao = new CallendarDAO();
			List<CallendarDTO> calList = cdao.getMyCal(dto.getEno());
			
			JSONArray array = new JSONArray();
			
			for(CallendarDTO cdto : calList) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("title", cdto.getTitle());
				jsonObj.put("start", cdto.getStartDate());
				jsonObj.put("end", cdto.getEndDate()+"T24:00:00");
				
				String color = "";
				
				if(cdto.getType() ==  1) {
					color = "#257e4a";
				} else {
					color = "#999999";
				}
				jsonObj.put("color", color);
				array.add(jsonObj);
			}
			
			req.setAttribute("myList", array.toJSONString());
			req.setAttribute("maindto", maindto);
			req.setAttribute("board", list);
			req.setAttribute("scrap", scrap);

		}
		return "main/main.jsp";
	}

}
