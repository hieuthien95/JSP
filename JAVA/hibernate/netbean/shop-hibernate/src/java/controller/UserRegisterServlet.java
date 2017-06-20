package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAOImpl;
import model.User;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAOImpl userDAOImpl = new UserDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String url = "/login.jsp";

		String username_err = "", password_err = "";

		if (username.equals("")) {
			username_err = "Vui lòng nhập username";
		} else {
			if (userDAOImpl.checkUsername(username))
				password_err = "Username đã tồn tại";
		}

		if (password.equals("")) {
			password_err = "Vui lòng nhập password";
		} else {
			if (password.length() < 5) {
				password_err = "Vui lòng nhập password";
			}
		}
		if (username_err.length() > 0) {
			request.setAttribute("username_err", username_err);
			request.setAttribute("username", username);
		}
		if (password_err.length() > 0) {
			request.setAttribute("password_err", password_err);
		}

		try {
			if (username_err.length() == 0 && password_err.length() == 0) {
				userDAOImpl.insertUser(new User(0, username, password, 2));
				url = "/index.jsp";
			} else {
				url = "/login.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
