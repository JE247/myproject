package kr.co.jhta.project.main.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class InsertEmpActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String saveDir = req.getRealPath("/images/myinfo");
		int maxFile = 1024 * 1024 * 10; // 10Mbyte
		
		System.out.println(saveDir);
		
		MultipartRequest mr;
		
		try {
			mr = new MultipartRequest(req, saveDir, maxFile, "UTF-8", new DefaultFileRenamePolicy());
			
			String no = mr.getParameter("dno");
			
			int dno = 0;
			
			if(no != null) {
				dno = Integer.parseInt(no);
			}
			
			OfficeWorkerDAO dao = new OfficeWorkerDAO();
			
			String name = mr.getParameter("name");
			String password = mr.getParameter("pw");
			String birth = mr.getParameter("birth");
			String hiredate = mr.getParameter("hire");
			
			String addrs1 = mr.getParameter("addrs1");
			String addrs2 = mr.getParameter("addrs2");
			
			String addrs = "";
			
			if(addrs2 == null) {
				addrs = addrs1;
			} else {
				addrs = addrs1 + " " + addrs2;
			}

			String phone = mr.getParameter("phone");
			String mail = mr.getParameter("email");
	
			String job = mr.getParameter("job");
			String position = mr.getParameter("position");
			String photoname = mr.getOriginalFileName("photo");
						
			OfficeWorkerDTO dto = new OfficeWorkerDTO();
			
			dto.setName(name);
			dto.setAddrs(addrs);
			dto.setPhone(phone);
			dto.setMail(mail);
			dto.setDno(dno);
			dto.setJob(job);
			dto.setPosition(position);
			dto.setPhotoname(photoname);
			dto.setPassword(password);
			dto.setBirth(birth);
			dto.setHiredate(hiredate);
			
//			System.out.println("name : " + name);
//			System.out.println("pw : " + password);
//			System.out.println("birth : " + birth);
//			System.out.println("hire : " + hiredate);
//			System.out.println("addrs : " + addrs);
//			System.out.println("phone : " + phone);
//			System.out.println("email : " + mail);
//			System.out.println("dno : " + dno);
//			System.out.println("job : " + job);
//			System.out.println("position : " + position);
//			System.out.println("photoname : " + photoname);
			
			dao.insertEmp(dto);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MyProject.do?cmd=allemp";
	}

}
