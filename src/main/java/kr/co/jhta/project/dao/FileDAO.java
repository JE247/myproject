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
	
	public void writeOne(FileDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.file.writeOne", dto);
		ss.close();
	}

	public String getFileName(int fno) {
		SqlSession ss = factory.openSession(true);
		String file = ss.selectOne("kr.co.jhta.mapper.file.getFileName", fno);
		ss.close();
		return file;
	}

	public void deleteFiles(int fno) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.file.deleteFiles", fno);
		ss.close();
	}

}
