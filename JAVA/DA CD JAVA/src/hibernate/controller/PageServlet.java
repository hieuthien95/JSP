/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.LoaiSanPhamDAO;
import hibernate.dao.SanPhamDAO;

public class PageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		// product-content.jsp
		request.setAttribute("getNewSanPham", new SanPhamDAO().getNewSanPham());
		request.setAttribute("getAllSanPham", new SanPhamDAO().getAllSanPham());
		request.setAttribute("getAllLoaiSanPham", new LoaiSanPhamDAO().getAllLoaiSanPham());

		// banner.jsp
		request.setAttribute("getTopSanPham", new SanPhamDAO().getTopSanPham());

		// // cookie
		// if(request.getSession().getAttribute("user") == null) {
		// String username = null, password = null;
		// Cookie []cookie = request.getCookies();
		// for(int i = 0; i<cookie.length; i++) {
		// if(cookie[i].getName().equals("username"))
		// username = cookie[i].getValue();
		// else if(cookie[i].getName().equals("password"))
		// password = cookie[i].getValue();
		// }
		// if(username!=null && password !=null) {
		// RequestDispatcher rd =
		// getServletContext().getRequestDispatcher("/UserServlet?ac=loginwithcookie&username="
		// + username + "&password=" + password);
		// rd.forward(request, response);
		// return;
		// }
		// }

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
