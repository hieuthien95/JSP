package controller;

import java.io.IOException;

import dao.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDAOImpl productDAOImpl = new ProductDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.jsp";

		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		String productID = request.getParameter("productID");
		Cart cart = (Cart) session.getAttribute("cart");

		try {
			long idProduct = Long.parseLong(productID);
			Product product = productDAOImpl.getListProductByProductID((int) idProduct);
			switch (command) {
			case "insertItem":
				if (cart.getCartItems().containsKey(idProduct)) {
					cart.insertToCart(idProduct, new Item(product, cart.getCartItems().get(idProduct).getQuantity()));
				} else {
					cart.insertToCart(idProduct, new Item(product, 1));
				}
				url = "index.jsp";
				break;
			case "plus":
				if (cart.getCartItems().containsKey(idProduct)) {
					cart.insertToCart(idProduct, new Item(product, cart.getCartItems().get(idProduct).getQuantity()));
				} else {
					cart.insertToCart(idProduct, new Item(product, 1));
				}
				url = "cart.jsp";
				break;
			case "removeItem":
				cart.removeToCart(idProduct);
				url = "cart.jsp";
				break;
			}

			session.setAttribute("cart", cart);
			response.sendRedirect(url);
		} catch (Exception e) {
			response.sendRedirect(url);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
