package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.EnoBnoDTO;
import kr.co.jhta.project.dto.FileDTO;
import kr.co.jhta.project.dto.MeetingRoomDTO;
import kr.co.jhta.project.dto.PagingSearch;
import kr.co.jhta.project.dto.ScrapDTO;

public class MeetingRoomDAO {
	
	private SqlSessionFactory factory;

	public MeetingRoomDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<MeetingRoomDTO> getAll() {
		SqlSession ss = factory.openSession(true);
		List list = ss.selectList("kr.co.jhta.mapper.meetingroom.getAll");
		ss.close();
		return list;
	}
	
}
