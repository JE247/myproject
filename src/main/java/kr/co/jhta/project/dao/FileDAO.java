package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.FileDTO;
import kr.co.jhta.project.dto.PagingSearch;

public class FileDAO {
	
	private SqlSessionFactory factory;

	public FileDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<FileDTO> getOne(int bno) {
		SqlSession ss = factory.openSession(true);
		List<FileDTO> list = ss.selectList("kr.co.jhta.mapper.file.getOne", bno);
		ss.close();
		return list;
	}

}
