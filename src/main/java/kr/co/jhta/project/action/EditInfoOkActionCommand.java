package kr.co.jhta.project.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.jhta.project.dao.OfficeWorkerDAO;
import kr.co.jhta.project.dto.OfficeWorkerDTO;

public class EditInfoOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String saveDir = req.getRealPath("/images/myinfo");
		int maxFile = 1024 * 1024 * 10; // 10Mbyte
		
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(req, saveDir, maxFile, "UTF-8", new DefaultFileRenamePolicy());
			
			String eno = mr.getParameter("eno");
			int no = 0;
			if(eno != null) {
				no = Integer.parseInt(eno);
			}
			
			String name = mr.getParameter("name");
			String password = mr.getParameter("repw");
			
			String addrs1 = mr.getParameter("addrs1");
			String addrs2 = req.getParameter("addrs2");
			
			String addrs = "";
			
			if(addrs2 == null) {
				addrs = addrs1;
			} else {
				addrs = addrs1 + addrs2;
			}
			
			String phone = mr.getParameter("phone");
			String mail = mr.getParameter("email");
			String photoname = mr.getOriginalFileName("photo");
			
			OfficeWorkerDTO dto = new OfficeWorkerDTO();
			
			dto.setEno(no);
			dto.setName(name);
			dto.setPassword(password);
			dto.setAddrs(addrs);
			dto.setPhone(phone);
			dto.setMail(mail);
			dto.setPhotoname(photoname);
			
			OfficeWorkerDAO dao = new OfficeWorkerDAO();
			dao.editInfo(dto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return "MyProject.do?cmd=main";
	}

}
