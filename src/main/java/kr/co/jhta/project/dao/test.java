package kr.co.jhta.project.dao;

import kr.co.jhta.project.dto.ChatMessageDTO;

public class test {
	public static void main(String[] args) {
//
//		ChatPersonDAO personDao = new ChatPersonDAO();
//		ChatMessageDAO dao = new ChatMessageDAO();
//		
//		ChatMessageDTO chat = new ChatMessageDTO();
//		chat.setMno(10);
//		chat.setChatno(3);
//
//		List<ChatMessageDTO> list = dao.realTime(chat);
//
//		for (ChatMessageDTO dto : list) {
//			System.out.println(dto.getMessage());
//		}
		
		ChatStatusDAO dao = new ChatStatusDAO();
		ChatMessageDTO dto = new ChatMessageDTO();
		dto.setEno(20220003);
		dto.setChatno(3);
		
		int num = dao.noRead(dto);
		System.out.println(num);
		

	}
}
