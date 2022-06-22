package kr.co.jhta.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.jhta.project.dto.ChatDTO;

public class ChatDAO {
	
	private SqlSessionFactory factory;

	public ChatDAO() {
		factory = ConnectionManager.getInstance().getFactory();
	}
	
	public List<ChatDTO> myChat(int eno) {
		SqlSession ss = factory.openSession(true);
		List<ChatDTO> list = ss.selectList("kr.co.jhta.mapper.chat.myChat", eno);
		ss.close();
		return list;
	}
	
	public int findNo(int eno) {
		SqlSession ss = factory.openSession(true);
		int no = ss.selectOne("kr.co.jhta.mapper.chat.findNo", eno);
		ss.close();
		return no;
	}
	
	public void addChat(ChatDTO dto) {
		SqlSession ss = factory.openSession(true);
		ss.insert("kr.co.jhta.mapper.chat.addChat",dto);
		ss.close();
	}

}
