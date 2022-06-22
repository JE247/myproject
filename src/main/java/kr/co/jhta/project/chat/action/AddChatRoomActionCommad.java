package kr.co.jhta.project.chat.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.DepartmentDAO;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.MemberDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class AddChatRoomActionCommad implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OfficeWorkerDAO odao = new OfficeWorkerDAO();
		List<OfficeWorkerDTO> memberList = null;
		String d = req.getParameter("dept");
		
		if(d == null || d.equals("")) {
			memberList = odao.getAll();
		} else {
			int dept = Integer.parseInt(d);
			
			OfficeWorkerDTO dto = new OfficeWorkerDTO();
			dto.setDno(dept);
			memberList = odao.getFilter(dto);
			
			req.setAttribute("dept", dept);
		}
		
		DepartmentDAO ddao = new DepartmentDAO();
		List<DepartmentDTO> deptList = ddao.getAll();
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		for(OfficeWorkerDTO dto : memberList) {
			
			MemberDTO member = new MemberDTO();
			
			member.setEno(dto.getEno());
			member.setDno(dto.getDno());
			member.setDname(ddao.getOne(dto.getDno()).getDname());
			member.setName(dto.getName());
			
			list.add(member);
		}
		req.setAttribute("memberList", list);
		req.setAttribute("deptList", deptList);
		return "chat/addRoom.jsp";
	}

}
