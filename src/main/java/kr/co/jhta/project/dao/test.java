package kr.co.jhta.project.dao;

import java.util.List;

import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class test {
	public static void main(String[] args) {
		OfficeWorkerDAO dao = new OfficeWorkerDAO();
		OfficeWorkerDTO dto = new OfficeWorkerDTO();
//		dto.setEno(20220002);
//		dto.setPassword("test2");
//		dto.setName("홍길동");
//		dto.setAddrs("");
//		dto.setPhone("11");
//		dto.setMail("22");
//		dao.editInfo(dto);
		
		dto.setDno(1);
		dto.setPosition("");
		
		
//		DepartmentDAO dao = new DepartmentDAO();
		List<OfficeWorkerDTO> list = dao.getFilter(dto);
		
		for(OfficeWorkerDTO dto1 : list) {
			System.out.println(dto1.getEno());
		}
	}

}
