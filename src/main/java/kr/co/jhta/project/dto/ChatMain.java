package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMain {
	int cno;
	int person;
	int noread;
	String chatName;
	String chatMessage;
	String chatTime;
}
