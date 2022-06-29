package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.CalendarDTO;
import kr.co.jhta.project.dto.DateEno;

public class CalendarDAO {
	
	SqlSessionFactory factory;
	
	public CalendarDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<CalendarDTO> getMyCal(int eno){
		
		SqlSession ss = factory.openSession(true);
		List<CalendarDTO> list = ss.selectList("kr.co.jhta.mapper.callendar.getMyCal", eno);
		ss.close();
		return list;
	}
	
	public List<CalendarDTO> getMyCalFilter(DateEno de) {
		SqlSession ss = factory.openSession(true);
		List<CalendarDTO> list = ss.selectList("kr.co.jhta.mapper.callendar.getMyCalFilter", de);
		ss.close();
		return list;
	}
	
	public CalendarDTO getOne(int cno) {
		SqlSession ss = factory.openSession(true);
		CalendarDTO dto = ss.selectOne("kr.co.jhta.mapper.callendar.getOne", cno);
		ss.close();
		return dto;
	}
	
	public void updateOk(CalendarDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.mapper.callendar.updateOk",dto);
		ss.close();
	}
	
	public void deleteOne(int cno) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.callendar.deleteOne", cno);
		ss.close();
	}
	
	public void addCal(CalendarDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.callendar.addCal", dto);
		ss.close();
	}



}
