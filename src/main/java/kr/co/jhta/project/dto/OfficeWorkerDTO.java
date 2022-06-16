package kr.co.jhta.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeWorkerDTO {
	
	int eno;
	String name;
	String password;
	String phone;
	String mail;
	String birth;
	String addrs;
	int auth;
	int leave;
	String hiredate;
	int dno;
	String job;
	String position;
	String photoname;

}
