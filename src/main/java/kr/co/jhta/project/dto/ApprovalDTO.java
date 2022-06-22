package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalDTO {
	int ano;
	int dcno;
	int status;
	int eno;
	String appdate;
	String reason;
}
