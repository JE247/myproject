package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.ChatMessageDTO;
import kr.co.jhta.project.dto.ChatPersonDTO;

public class ChatMessageDAO {
	
	private SqlSessionFactory factory;

	public ChatMessageDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<ChatMessageDTO> recentMessage(int chatno){
		SqlSession ss = factory.openSession(true);
		List<ChatMessageDTO> list = ss.selectList("kr.co.jhta.mapper.chatmessage.recentMessage", chatno);
		ss.close();
		return list;
	}

	public List<ChatMessageDTO> realTime(ChatMessageDTO dto){
		SqlSession ss = factory.openSession(true);
		List<ChatMessageDTO> list = ss.selectList("kr.co.jhta.mapper.chatmessage.realTime", dto);
		ss.close();
		return list;
	}
	
	public ChatMessageDTO finalMessage(int chatno) {
		SqlSession ss = factory.openSession(true);
		ChatMessageDTO dto = ss.selectOne("kr.co.jhta.mapper.chatmessage.finalMessage",chatno);
		ss.close();
		return dto;
	}
	
	public int findNo(ChatMessageDTO dto) {
		SqlSession ss = factory.openSession(true);
		int num = ss.selectOne("kr.co.jhta.mapper.chatmessage.findNo",dto);
		ss.close();
		return num;
	}
	
	public void addMessage(ChatMessageDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.chatmessage.addMessage", dto);
		ss.close();
	}

}
