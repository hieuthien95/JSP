package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.SanPhamDAO;
import model.Cart;
import model.Item;
import model.SanPham;

public class CartController extends ActionSupport implements SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private HttpServletRequest request;

	private SanPham sanpham;
	String url;

	public CartController() {
		super();
	}

	public CartController(Map<String, Object> session, HttpServletRequest request) {
		super();
		this.session = session;
		this.request = request;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	// Cart -------------------------------------------------------

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String addToCart() throws Exception {
		url = request.getHeader("referer");
		sanpham = new SanPhamDAO().getSanPhamById(sanpham.getId());

		int old_qty = 1;

		Cart cart = new Cart();
		if (session.containsKey("cart")) {
			cart = (Cart) session.get("cart");
		}

		if (cart.getDsItem().containsKey((long) sanpham.getId())) {
			old_qty = cart.getDsItem().get((long) sanpham.getId()).getQty();
		}

		cart.insertToCart((long) sanpham.getId(), new Item(sanpham, old_qty));
		session.put("cart", cart);

		session.put("success", "Đã thêm vào giỏ hàng");

		return SUCCESS;
	}

	public String removeInCart() throws Exception {
		url = request.getHeader("referer");

		if (session.containsKey("cart")) {
			Cart cart = (Cart) session.get("cart");
			if (cart.getDsItem().containsKey((long) sanpham.getId())) {
				cart.removeToCart((long) sanpham.getId());
			}

			session.put("cart", cart);
		}

		session.put("error", "Đã xóa sản phẩm khỏi giỏ hàng");

		return SUCCESS;
	}

	public String subInCart() throws Exception {
		url = request.getHeader("referer");

		sanpham = new SanPhamDAO().getSanPhamById(sanpham.getId());

		if (session.containsKey("cart")) {
			Cart cart = (Cart) session.get("cart");
			if (cart.getDsItem().containsKey((long) sanpham.getId())) {
				cart.subInCart((long) sanpham.getId(),
						new Item(sanpham, cart.getDsItem().get((long) sanpham.getId()).getQty()));
			}

			session.put("cart", cart);
		}

		session.put("error", "Đã xóa sản phẩm khỏi giỏ hàng");
		return SUCCESS;

	}

	// --------------------------------------------------------------

	public String addToSoSanh() throws Exception {
		url = request.getHeader("referer");

		sanpham = new SanPhamDAO().getSanPhamById(sanpham.getId());

		int old_qty = 1;

		Cart cart = new Cart();
		if (session.containsKey("compare")) {
			cart = (Cart) session.get("compare");
		}

		if (cart.getDsItem().containsKey((long) sanpham.getId())) {
			old_qty = cart.getDsItem().get((long) sanpham.getId()).getQty();
		}

		cart.insertToCart((long) sanpham.getId(), new Item(sanpham, old_qty));
		session.put("compare", cart);

		session.put("success", "Đã thêm vào sản phẩm so sánh");
		return SUCCESS;
	}

	public String removeInSoSanh() throws Exception {
		url = request.getHeader("referer");

		if (session.containsKey("compare")) {
			Cart cart = (Cart) session.get("compare");
			if (cart.getDsItem().containsKey((long) sanpham.getId())) {
				cart.removeToCart((long) sanpham.getId());
			}

			session.put("compare", cart);
		}

		session.put("error", "Đã xóa sản phẩm khỏi sản phẩm so sánh");
		return SUCCESS;
	}

}
