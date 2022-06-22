package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.EnoBnoDTO;
import kr.co.jhta.project.dto.FileDTO;
import kr.co.jhta.project.dto.MeetingRoomDTO;
import kr.co.jhta.project.dto.PagingSearch;
import kr.co.jhta.project.dto.ReservationDTO;
import kr.co.jhta.project.dto.ScrapDTO;

public class ReservationDAO {
	
	private SqlSessionFactory factory;

	public ReservationDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<ReservationDTO> todayOneRez(ReservationDTO dto) {
		SqlSession ss = factory.openSession(true);
		List<ReservationDTO> list = ss.selectList("kr.co.jhta.mapper.reservation.todayOneRez", dto);
		ss.close();
		return list;
	}

	public List<ReservationDTO> myRez(int eno) {
		SqlSession ss = factory.openSession(true);
		List<ReservationDTO> list = ss.selectList("kr.co.jhta.mapper.reservation.myRez", eno);
		ss.close();
		return list;
	}
	
	public ReservationDTO getOne(int rezNo) {
		SqlSession ss = factory.openSession(true);
		ReservationDTO dto = ss.selectOne("kr.co.jhta.mapper.reservation.getOne", rezNo);
		ss.close();
		return dto;
	}

	public boolean timeCheck(ReservationDTO dto) {
		
		boolean timeCheckDate = false;

		SqlSession ss = factory.openSession(true);
		int num = ss.selectOne("kr.co.jhta.mapper.reservation.timeCheck",dto);
		
		if(num > 0) {
			timeCheckDate = true;
		}
		
		ss.close();
		
		return timeCheckDate;
	}
	
	public void addRez(ReservationDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.reservation.addRez", dto);
		ss.close();
	}
	
	public void deleteOne(int rez) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.reservation.deleteOne", rez);
		ss.close();
	}
}
