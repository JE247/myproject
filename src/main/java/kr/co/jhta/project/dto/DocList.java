package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocList {
	int dcno;
	int stauts;
	String dtitle;
	String manager;
	String appDate;
}
