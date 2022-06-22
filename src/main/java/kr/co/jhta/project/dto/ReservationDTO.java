package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
	int rezNo;
	int eno;
	int roomNo;
	String rezDate;
	int startTime;
	int endTime;
	int people;
	String memo;
}
