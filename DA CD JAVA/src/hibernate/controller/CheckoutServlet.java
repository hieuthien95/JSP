package hibernate.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hibernate.dao.DonHangDAO;
import hibernate.dao.UserDAO;
import hibernate.model.Cart;
import hibernate.model.DonHang;
import hibernate.model.Item;
import hibernate.model.User;
import tool.SendMail;

public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();

		String command = request.getParameter("command");

		switch (command) {
		case "insert":
			Cart cart = (Cart) session.getAttribute("cart");

			if (cart != null && cart.countItem() > 0) {
				String ghiChu = "";
				DonHang bill = null;
				long stt = 0;

				if (cart != null)
					for (Map.Entry<Long, Item> i : cart.getCartItems().entrySet())
						ghiChu += i.getValue().getProduct().getTen() + "(" + i.getValue().getProduct().getStt() + ")x"
								+ i.getValue().getQuantity() + "; ";

				User user = (User) session.getAttribute("user");
				if (user == null) {
					stt = new Date().getTime();
					bill = new DonHang(stt, (long) cart.total(), "", ghiChu, "",
							new Timestamp(new Date().getTime()) + " ");

				} else {
					stt = new Date().getTime();
					bill = new DonHang(stt, (long) cart.total(), user.getSdt(), ghiChu, "",
							new Timestamp(new Date().getTime()) + " ");

					try {
						SendMail.sendMail(user.getEmail(), "Giao dịch",
								"Hello " + user.getEmail() + "\nTotal VNĐ" + (long) cart.total());
					} catch (Exception e) {
					}

				}

				new DonHangDAO().insert(bill);

				String url = "https://www.nganluong.vn/button_payment.php?receiver=hieuthien95@gmail.com&product_name="
						+ stt + "&price=" + (long) cart.total()
						+ "&return_url=http://localhost:8084/CheckoutServlet?command=update&comments=" + ghiChu;

				response.sendRedirect(url);
				return;
			}
			break;
		case "update":
			long order_code = Long.parseLong(request.getParameter("order_code"));
			long price = Integer.parseInt(request.getParameter("price"));
			String payment_id = request.getParameter("payment_id");

			new DonHangDAO()
					.update(new DonHang(order_code, 0, "", "", payment_id, new Timestamp(new Date().getTime()) + " "));

			User user = (User) session.getAttribute("user");
			if (user != null) {
				user.setDiemTichTuy(user.getDiemTichTuy() + (int) (price / 1000));
				new UserDAO().update(user);
			}

			response.sendRedirect("/checkout.jsp");
			return;
		}

		response.sendRedirect(request.getHeader("referer"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
