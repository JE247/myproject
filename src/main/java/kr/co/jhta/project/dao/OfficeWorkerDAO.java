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
	
	public List<OfficeWorkerDTO> getAll(){
		SqlSession ss = factory.openSession(true);
		List<OfficeWorkerDTO> list = ss.selectList("kr.co.jhta.mapper.getAll");
		ss.close();
		return list;
	}
	public List<OfficeWorkerDTO> getFilter(OfficeWorkerDTO dto){
		SqlSession ss = factory.openSession(true);
		List<OfficeWorkerDTO> list = ss.selectList("kr.co.jhta.mapper.getFilter", dto);
		ss.close();
		return list;
	}
	
	
	public List<String> getPosition(){
		SqlSession ss = factory.openSession(true);
		List<String> list = ss.selectList("kr.co.jhta.mapper.getposition");
		ss.close();
		return list;
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
	
	public void editInfo(OfficeWorkerDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.mapper.editInfo", dto);
		ss.close();
	}
	public void editEmpInfo(OfficeWorkerDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.mapper.editempinfo", dto);
		ss.close();
	}
	
	public void insertEmp(OfficeWorkerDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.insertEmp", dto);
		ss.close();
	} 
	
	public void deleteEmp(int eno) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.deleteEmp", eno);
		ss.close();
	}
}
