package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChiTietHoaDonDAOImpl;
import dao.HoaDonDAOImpl;
import model.Cart;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.Item;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HoaDonDAOImpl hoaDonDAOImpl = new HoaDonDAOImpl();
	ChiTietHoaDonDAOImpl chiTietHoaDonDAOImpl = new ChiTietHoaDonDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String url = "index.jsp";

		String dia_chi = request.getParameter("dia_chi");
		String dien_thoai = request.getParameter("dien_thoai");

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		String ma_khach_hang = (String) session.getAttribute("username");
		ArrayList<Long> listBuy = (ArrayList<Long>) session.getAttribute("cartID");

		if (listBuy == null) {
			listBuy = new ArrayList<>();
			session.setAttribute("cartID", listBuy);
		}

		try {
			HoaDon hoaDon = new HoaDon();
			
			hoaDon = hoaDonDAOImpl.insertHoaDon(new HoaDon(0, ma_khach_hang, dia_chi, dien_thoai, new Date()));
			for (Map.Entry<Long, Item> entry : cart.getCartItems().entrySet()) {
				chiTietHoaDonDAOImpl
						.insertChiTietHoaDon(new ChiTietHoaDon(0, hoaDon.getMa_hoa_don(), entry.getValue().getProduct().getProduct_id(),
								entry.getValue().getQuantity(), (int) entry.getValue().getProduct().getPrice()));
			}

			url = "index.jsp";
		} catch (Exception e) {
			url = "checkout.jsp";
		}
		
		response.sendRedirect(url);

	}

}
