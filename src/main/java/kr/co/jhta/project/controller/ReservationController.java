package kr.co.jhta.project.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhta.project.reservation.action.AddOkActionCommand;
import kr.co.jhta.project.reservation.action.AddRezFormActionCommad;
import kr.co.jhta.project.reservation.action.RezActionCommand;
import kr.co.jhta.project.reservation.action.DeleteActionCommand;



@WebServlet("/MyProjectRez.do")
public class ReservationController extends HttpServlet {

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Action ac = null;

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			String cmd = request.getParameter("cmd");
			String url = "";

			if (cmd == null || cmd.equals("rez")) {
				ac = new RezActionCommand();
			} else if (cmd.equals("addRez")) {
				ac = new AddRezFormActionCommad();
			} else if (cmd.equals("addOk")) {
				ac = new AddOkActionCommand();
			} else if (cmd.equals("delete")) {
				ac = new DeleteActionCommand();
			}

			url = ac.execute(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
