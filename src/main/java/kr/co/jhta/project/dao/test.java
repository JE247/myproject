package kr.co.jhta.project.dao;

import java.util.List;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;
import kr.co.jhta.project.dto.PagingSearch;

public class test {
	public static void main(String[] args) {
//		OfficeWorkerDAO dao = new OfficeWorkerDAO();
//		OfficeWorkerDTO dto = new OfficeWorkerDTO();
//		
//		
//		DepartmentDAO dao = new DepartmentDAO();
		
		BoardDAO dao = new BoardDAO();
		PagingSearch ps = new PagingSearch(1, 11, "writer", "홍");
		
		
		List<BoardDTO> list = dao.getAll(ps);
		
		
		for(BoardDTO dto1 : list) {
			System.out.println(dto1.getBno());
		}
	}

}
