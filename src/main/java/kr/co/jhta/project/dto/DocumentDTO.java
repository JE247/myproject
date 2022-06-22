package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
	int dcno;
	int eno;
	String dcontents;
	String dregdate;
	int dtype;
}
