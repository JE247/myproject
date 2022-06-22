package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mysql.cj.xdevapi.SessionFactory;

import kr.co.jhta.project.dto.ApprovalDTO;
import kr.co.jhta.project.dto.DocTypeDTO;
import kr.co.jhta.project.dto.DocumentDTO;

public class DocumentDAO {

	SqlSessionFactory factory;

	public DocumentDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}

	public List<DocumentDTO> myList(int eno) {
		SqlSession ss = factory.openSession(true);
		List<DocumentDTO> list = ss.selectList("kr.co.jhta.mapper.document.myList", eno);
		ss.close();
		return list;
	}
	
	public DocumentDTO getOne(int dcno) {
		SqlSession ss = factory.openSession(true);
		DocumentDTO dto = ss.selectOne("kr.co.jhta.mapper.document.getOne", dcno);
		ss.close();
		return dto;
	}

	public List<DocumentDTO> myListFilter(ApprovalDTO dto) {
		SqlSession ss = factory.openSession(true);
		List<DocumentDTO> list = ss.selectList("kr.co.jhta.mapper.document.myListFilter", dto);
		ss.close();
		return list;
	}

	public int findNum(int eno) {
		SqlSession ss = factory.openSession(true);
		int num = ss.selectOne("kr.co.jhta.mapper.document.findNum", eno);
		ss.close();
		return num;
	}

	public void addOne(DocumentDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.document.addOne", dto);
		ss.close();
	}
	
	public void delete(int dcno) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.document.delete", dcno);
		ss.close();
	}

}
