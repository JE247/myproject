package kr.co.jhta.project.dao;

import java.util.List;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.DocTypeDTO;
import kr.co.jhta.project.dto.EnoBnoDTO;
import kr.co.jhta.project.dto.FileDTO;
import kr.co.jhta.project.dto.MeetingRoomDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;
import kr.co.jhta.project.dto.PagingSearch;
import kr.co.jhta.project.dto.ReservationDTO;
import kr.co.jhta.project.dto.ScrapDTO;

public class test {
	public static void main(String[] args) {
		
//		MeetingRoomDAO dao = new MeetingRoomDAO();
//		List<MeetingRoomDTO> list = dao.getAll();
//		
//		for(MeetingRoomDTO dto : list) {
//			System.out.println(dto.getRoomName());
//		}
		
		DocTypeDAO dao = new DocTypeDAO();
		List<DocTypeDTO> list = dao.getAll();
		
		for(DocTypeDTO dto1 : list) {
			System.out.println(dto1.getDtitle());
		}
	}
}
