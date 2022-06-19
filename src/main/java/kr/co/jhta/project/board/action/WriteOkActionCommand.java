package kr.co.jhta.project.board.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.co.jhta.project.controller.Action;
import kr.co.jhta.project.dao.BoardDAO;
import kr.co.jhta.project.dao.FileDAO;
import kr.co.jhta.project.dto.BoardDTO;
import kr.co.jhta.project.dto.FileDTO;

public class WriteOkActionCommand implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String realPath = "";
		String savePath = "file";
		String type = "utf-8";
		int maxSize = 10*1024*1024;

		ServletContext context = req.getServletContext();
		realPath = context.getRealPath(savePath);

		Map<String, String> requestQuery = new HashMap<String, String>();

		try{
		DiskFileItemFactory dfif = new DiskFileItemFactory();

		dfif.setRepository(new File(realPath));
		dfif.setSizeThreshold(maxSize);
		dfif.setDefaultCharset("UTF-8");

		ServletFileUpload fileUpload = new ServletFileUpload(dfif);

		List<FileItem> items = fileUpload.parseRequest(req);
		ArrayList<String> filesName = new ArrayList<String>();
		
		int i=0;
		
		for(FileItem file : items){
			// 파일이 아니라면
			if(file.isFormField()){ 
				
				String inputName = file.getFieldName();
				String value = file.getString();
				
				requestQuery.put(inputName, value);
				
			// 파일 이라면	
			} else {
					if(file.getSize() > 0){
						
						String separator = File.separator; // 윈도우상 파일 경로 구분자
						
						int index = file.getName().lastIndexOf(separator); // 구분자가 위치한 마지막 자리수
						
						String fileName = file.getName().substring(index + 1); //실제 경로 뒤의 마지막 파일 명
						filesName.add(fileName);
						File uploadFile = new File(realPath + separator + fileName); // upload한 실제 경로
						
						file.write(uploadFile); // 파일 업로드 하기
					}
			}
		}
		
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(requestQuery.get("writer"));
		dto.setTitle(requestQuery.get("title"));
		dto.setContents(requestQuery.get("contents"));
		
		BoardDAO bdao = new BoardDAO();
		
		bdao.writeOne(dto);
		
		int bno = bdao.searchBno(dto.getWriter());
		
		if(filesName.size() > 0) {
			
			for(String fileOne : filesName) {
				
				FileDAO fdao = new FileDAO();
				FileDTO fdto = new FileDTO();
				fdto.setBno(bno);
				fdto.setFilename(fileOne);
				
				fdao.writeOne(fdto);
			}
		}
		
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return "MyProjectBoard.do?cmd=board";
	}

}
