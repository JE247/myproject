package kr.co.jhta.project.dao;

import java.util.List;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.FileDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;
import kr.co.jhta.project.dto.PagingSearch;

public class test {
	public static void main(String[] args) {
//		OfficeWorkerDAO dao = new OfficeWorkerDAO();
//		OfficeWorkerDTO dto = new OfficeWorkerDTO();
//		
//		
//		DepartmentDAO dao = new DepartmentDAO();
	
		FileDAO dao = new FileDAO();
		List<FileDTO> list = dao.getOne(12);
		
		for(FileDTO dto : list) {
			System.out.println(dto.getFilename());
		}
	}

}
