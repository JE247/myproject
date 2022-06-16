package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.OfficeWorkerDTO;


public class OfficeWorkerDAO {
	private SqlSessionFactory factory;

	public OfficeWorkerDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public OfficeWorkerDTO login(OfficeWorkerDTO logdto) {
		
		
		SqlSession ss = factory.openSession(true);
		OfficeWorkerDTO dto = ss.selectOne("kr.co.jhta.mapper.loginOk", logdto);
		
		ss.close();
		return dto;
	}
	
	public OfficeWorkerDTO myInfo(int eno) {
		
		SqlSession ss = factory.openSession(true);
		OfficeWorkerDTO dto = ss.selectOne("kr.co.jhta.mapper.myInfo", eno);
		
		ss.close();
		return dto;
	}
}
