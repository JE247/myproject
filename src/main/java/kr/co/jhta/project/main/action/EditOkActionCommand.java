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

public class EditOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String saveDir = req.getRealPath("/images/myinfo");
		int maxFile = 1024 * 1024 * 10; // 10Mbyte
		
		MultipartRequest mr;
		
		try {
			mr = new MultipartRequest(req, saveDir, maxFile, "UTF-8", new DefaultFileRenamePolicy());
			
			String eno = mr.getParameter("eno");
			String edno = mr.getParameter("dno");
			
			int no = 0;
			int dno = 0;
			if(eno != null && edno != null) {
				no = Integer.parseInt(eno);
				dno = Integer.parseInt(edno);
			}
			
			OfficeWorkerDAO dao = new OfficeWorkerDAO();
			OfficeWorkerDTO one = dao.myInfo(no);
			
			String name = mr.getParameter("name");
			
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
			
			
			if(photoname != null) {
				String fullpath = saveDir+File.separator+one.getPhotoname();
//				System.out.println(fullpath);
	 			File deleteFile = new File(fullpath);
				
				if(deleteFile.isFile()){
					deleteFile.delete();
				} 
			}
					
			OfficeWorkerDTO dto = new OfficeWorkerDTO();
			
			dto.setEno(no);
			dto.setName(name);
			dto.setAddrs(addrs);
			dto.setPhone(phone);
			dto.setMail(mail);
			dto.setDno(dno);
			dto.setJob(job);
			dto.setPosition(position);
			dto.setPhotoname(photoname);
			
			dao.editEmpInfo(dto);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MyProject.do?cmd=allemp";
	}

}
