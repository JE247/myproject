package kr.co.jhta.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginActionCommend implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("logindto");
		
		String url = "";
		if(obj == null) {
			url = "MyProject.do?cmd=loginForm";
		} else {
			url = "MyProject.do?cmd=main";
		}
		
		return url;
	}
}
