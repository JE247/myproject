package kr.co.jhta.project.dao;

import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class test {
	public static void main(String[] args) {
		OfficeWorkerDAO dao = new OfficeWorkerDAO();
		OfficeWorkerDTO dto = new OfficeWorkerDTO();
		dto.setEno(2);
		dto.setPassword("test");
		
		System.out.println(dao.login(dto));
	}

}
