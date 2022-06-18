package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.PagingSearch;

public class BoardDAO {
	
	private SqlSessionFactory factory;

	public BoardDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<BoardDTO> getAll(PagingSearch ps){
		SqlSession ss = factory.openSession(true);
		List<BoardDTO> list = ss.selectList("kr.co.jhta.mapper.board.getAll", ps);
		ss.close();
		return list;
	}
	
	public int getTotalCount(PagingSearch ps) {
		SqlSession ss = factory.openSession(true);
		int total = ss.selectOne("kr.co.jhta.mapper.board.getTotalCount", ps);
		ss.close();
		return total;
	}

}
