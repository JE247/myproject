package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.ChatMessageDTO;
import kr.co.jhta.project.dto.ChatPersonDTO;

public class ChatPersonDAO {
	
	private SqlSessionFactory factory;

	public ChatPersonDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public int countPerson(int chatno) {
		SqlSession ss = factory.openSession(true);
		int count = ss.selectOne("kr.co.jhta.mapper.chatperson.countPerson",chatno);
		ss.close();
		return count;
	}
	
	public List<ChatPersonDTO> findPerson(ChatMessageDTO chatdto) {
		SqlSession ss = factory.openSession(true);
		List<ChatPersonDTO> list = ss.selectList("kr.co.jhta.mapper.chatperson.findPerson",chatdto);
		ss.close();
		return list;
	}	
	
	public void addPerson(ChatPersonDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.chatperson.addPerson",dto);
		ss.close();
	}
	
	public void exit(ChatPersonDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.delete("kr.co.jhta.mapper.chatperson.exit", dto);
		ss.close();
	}

}
