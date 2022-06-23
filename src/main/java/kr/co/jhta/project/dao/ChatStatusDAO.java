package kr.co.jhta.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.ChatMessageDTO;
import kr.co.jhta.project.dto.ChatStatusDTO;

public class ChatStatusDAO {
	
	private SqlSessionFactory factory;

	public ChatStatusDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public int noRead(ChatMessageDTO dto) {
		SqlSession session = factory.openSession(true);
		int sum = 0;
		
		if(session.selectOne("kr.co.jhta.mapper.chatstatus.noRead", dto) != null) {
			sum = session.selectOne("kr.co.jhta.mapper.chatstatus.noRead", dto);
		}
		session.close();
		return sum;
	}

	public void addStatus(ChatStatusDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.chatstatus.addStatus",dto);
		ss.close();
	}
	
	public void readAll(ChatMessageDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.update("kr.co.jhta.mapper.chatstatus.readAll",dto);
		ss.close();
	}

}
