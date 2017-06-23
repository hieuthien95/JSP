package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HangSanXuatDAO;
import model.HangSanXuat;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String command = request.getParameter("command");

		if (command != null)
			switch (command) {
			case "update-hsx":
				int stt = Integer.parseInt(request.getParameter("stt"));
				String sttloaisp = request.getParameter("sttloaisp");

				HangSanXuat hsx = new HangSanXuatDAO().getHangSXByStt(stt);
				hsx.setSttloaisp(sttloaisp);

				new HangSanXuatDAO().update(hsx);
				response.sendRedirect(request.getHeader("referer"));
				return;

			case "delete-hsx":
				stt = Integer.parseInt(request.getParameter("stt"));

				new HangSanXuatDAO().delete((long) stt);

				response.sendRedirect(request.getHeader("referer"));
				return;

			default:
				response.sendRedirect(request.getHeader("referer"));
				return;
			}

		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("/admin/index.jsp");
	}

}
