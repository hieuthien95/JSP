package hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hibernate.dao.SanPhamDAO;
import hibernate.model.Cart;
import hibernate.model.Item;
import hibernate.model.SanPham;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		String productID = request.getParameter("productID");
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null)
			cart = new Cart();

		long idProduct = Long.parseLong(productID);
		SanPham product = new SanPhamDAO().getSanPhamByStt((int) idProduct);
		switch (command) {
		case "plus":
			if (cart.getCartItems().containsKey(idProduct)) {
				cart.insertToCart(idProduct, new Item(product, cart.getCartItems().get(idProduct).getQuantity()));
			} else {
				cart.insertToCart(idProduct, new Item(product, 1));
			}
			break;
		case "getnow":
			if (cart.getCartItems().containsKey(idProduct)) {
				cart.insertToCart(idProduct, new Item(product, cart.getCartItems().get(idProduct).getQuantity()));
			} else {
				cart.insertToCart(idProduct, new Item(product, 1));
			}
			session.setAttribute("cart", cart);
			response.sendRedirect("/checkout.jsp");
			return;
		case "remove":
			cart.removeToCart(idProduct);
			break;
		case "sub":
			if (cart.getCartItems().containsKey(idProduct)) {
				cart.subInCart(idProduct, new Item(product, cart.getCartItems().get(idProduct).getQuantity()));
			}
			break;
		}
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getHeader("referer"));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
