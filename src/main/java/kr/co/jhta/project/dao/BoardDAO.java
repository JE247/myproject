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
	
	public List<BoardDTO> scrapList(int eno){
		SqlSession ss = factory.openSession(true);
		List<BoardDTO> list = ss.selectList("kr.co.jhta.mapper.board.scrapList", eno);
		ss.close();
		return list;
	}
	
	public int getTotalCount(PagingSearch ps) {
		SqlSession ss = factory.openSession(true);
		int total = ss.selectOne("kr.co.jhta.mapper.board.getTotalCount", ps);
		ss.close();
		return total;
	}
	
	public BoardDTO getOne(int bno) {
		SqlSession ss = factory.openSession(true);
		BoardDTO dto = ss.selectOne("kr.co.jhta.mapper.board.getOne", bno);
		ss.close();
		return dto;
	}
	
	public void writeOne(BoardDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.board.writeOne", dto);
		ss.close();
	}
	
	public int searchBno(String name) {
		SqlSession ss = factory.openSession(true);
		int bno = ss.selectOne("kr.co.jhta.mapper.board.searchBno", name);
		ss.close();
		return bno;
	}
	
	public void hitsAdd(int bno) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.mapper.board.hitsAdd", bno);
		ss.close();
	}

	public void updateOne(BoardDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.mapper.board.updateOne", dto);
		ss.close();
	}

	public void deleteOne(int bno) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.board.deleteOne", bno);
		ss.close();
	}

}
