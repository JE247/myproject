package kr.co.jhta.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.ChatPersonDTO;

public class ChatPersonDAO {
	
	private SqlSessionFactory factory;

	public ChatPersonDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public void addPerson(ChatPersonDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.chatperson.addPerson",dto);
		ss.close();
	}

}
