package kr.co.jhta.project.board.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import kr.co.jhta.project.controller.Action;

public class DownloadActionCommad implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		int bno = 0;
		try {
			req.setCharacterEncoding("UTF-8");
			
			String no = req.getParameter("bno");
			if(no != null) {
				bno = Integer.parseInt(no);
			}
			
			/* 변수 선언하기 */
			InputStream in = null;
			OutputStream os = null;
			boolean skip = false;
			String client = "";


			/* 1. 다운로드 받을 파일의 이름 가져오기 */
			String fileName = req.getParameter("filename");

			/* 2. 다운받을 파일이 저장되어 있는 파일 위치 구하기*/
			String realPath = "";
			String savePath = "file";
			ServletContext context = req.getServletContext();
			realPath = context.getRealPath(savePath) + File.separator + fileName;

			/* 3. 다운받을 파일 불러오기 */
			File file = new File(realPath);

			/* 4. 파일을 읽어 스트림에 담기 */
			in = new FileInputStream(file);

			/* 사용자의 브라우저 탐색 */
			client = req.getHeader("User-Agent");

			/* 파일 다운로드 헤더 지정 */
			resp.reset();
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Description", "JSP Generated Data");

			/* 사용자의 브라우저가 Internet Explorer일 경우 */
			if(client.indexOf("MSIE") != -1){
			    resp.setHeader ("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("KSC5601"),"ISO8859_1"));

			}else{
			    // 한글 파일명 처리
			    fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");

			    resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			    resp.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			}

			resp.setHeader("Content-Length", ""+file.length()); 

			 os = resp.getOutputStream();
			byte b[] = new byte[(int)file.length()];
			int leng = 0;
			 
			while( (leng = in.read(b)) > 0 ){
			    os.write(b,0,leng);
			}

			in.close();
			os.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "MyProjectBoard.do?cmd=detail&bno="+bno;
	}

}
