package hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.DonHangDAO;
import hibernate.model.User;

public class DonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DonHangServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "";

		String command = request.getParameter("command");

		switch (command) {
		case "insert":

			break;
		case "remove":
			User sessionUser = (User) request.getSession().getAttribute("user");
			if (sessionUser == null || !sessionUser.getQuyen().equalsIgnoreCase("admin")
					&& !sessionUser.getQuyen().equalsIgnoreCase("Nhân viên")) {

				response.sendRedirect(request.getHeader("referer"));
				return;
			}

			long stt = Long.parseLong((String) request.getParameter("stt"));
			new DonHangDAO().delete(stt);

			response.sendRedirect(request.getHeader("referer"));
			return;

		case "update":

		}
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
