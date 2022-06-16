package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.DepartmentDTO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;


public class DepartmentDAO {
	private SqlSessionFactory factory;

	public DepartmentDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<DepartmentDTO> getAll() {
		
		SqlSession ss = factory.openSession(true);
		List<DepartmentDTO> list = ss.selectList("kr.co.jhta.mapper.dept.getAll");
		ss.close();
		return list;
		
	}
	
	public DepartmentDTO getOne(int dno) {
		
		SqlSession ss = factory.openSession(true);
		DepartmentDTO dto = ss.selectOne("kr.co.jhta.mapper.dept.getOne", dno);
		
		ss.close();
		return dto;
	}
}
