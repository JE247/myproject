package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mysql.cj.xdevapi.SessionFactory;

import kr.co.jhta.project.dto.ApprovalDTO;
import kr.co.jhta.project.dto.DocTypeDTO;
import kr.co.jhta.project.dto.DocumentDTO;

public class ApprovalDAO {

	SqlSessionFactory factory;

	public ApprovalDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<ApprovalDTO> appList(int eno){
		SqlSession ss = factory.openSession(true);
		List<ApprovalDTO> list = ss.selectList("kr.co.jhta.mapper.approval.appList", eno);
		ss.close();
		return list;
	
	}
	
	public ApprovalDTO getOne(int dcno) {
		SqlSession ss = factory.openSession(true);
		ApprovalDTO dto = ss.selectOne("kr.co.jhta.mapper.approval.getOne", dcno);
		ss.close();
		return dto;
	}


	public void addOne(ApprovalDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.approval.addOne", dto);
		ss.close();
	}

	public void appOne(ApprovalDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.mapper.approval.appOne", dto);
		ss.close();
	}
}
