package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallendarDTO {
	
	int cno;
	int eno;
	String title;
	String startDate;
	String endDate;
	String loc;
	String contents;
	int type;

}
