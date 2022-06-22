package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mysql.cj.xdevapi.SessionFactory;

import kr.co.jhta.project.dto.DocTypeDTO;

public class DocTypeDAO {

	SqlSessionFactory factory;

	public DocTypeDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}

	public List<DocTypeDTO> getAll() {
		SqlSession ss = factory.openSession(true);
		List<DocTypeDTO> list = ss.selectList("kr.co.jhta.mapper.doctype.getAll");
		ss.close();
		return list;
	}
	
	public DocTypeDTO getOne(int dtype) {
		SqlSession ss = factory.openSession(true);
		DocTypeDTO dto = ss.selectOne("kr.co.jhta.mapper.doctype.getOne", dtype);
		ss.close();
		return dto;
	}
}
