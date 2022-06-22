package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppList {
	int dcno;
	String dtitle;
	int eno;
	String name;
	String regdate;
}
