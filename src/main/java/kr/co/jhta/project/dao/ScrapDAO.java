package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.EnoBnoDTO;
import kr.co.jhta.project.dto.FileDTO;
import kr.co.jhta.project.dto.PagingSearch;
import kr.co.jhta.project.dto.ScrapDTO;

public class ScrapDAO {
	
	private SqlSessionFactory factory;

	public ScrapDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public ScrapDTO findScrap(EnoBnoDTO dto) {
		SqlSession ss = factory.openSession(true);
		ScrapDTO sdto = ss.selectOne("kr.co.jhta.mapper.scrap.findScrap", dto);
		ss.close();
		return sdto;
	}
	
	public void scrapAdd(EnoBnoDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.scrap.scrapAdd", dto);
		ss.close();
	}
	public void scrapRemove(EnoBnoDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.scrap.scrapRemove", dto);
		ss.close();
	}
}
