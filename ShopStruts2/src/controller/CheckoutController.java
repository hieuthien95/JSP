package controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.DonHangDAO;
import model.Cart;
import model.DonHang;
import model.Item;
import model.Users;

public class CheckoutController extends ActionSupport implements SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	private HttpServletRequest request;

	String url;

	long order_code;
	String payment_id;

	public CheckoutController() {
		super();
	}

	public CheckoutController(Map<String, Object> session, HttpServletRequest request) {
		super();
		this.session = session;
		this.request = request;
	}

	public long getOrder_code() {
		return order_code;
	}

	public void setOrder_code(long order_code) {
		this.order_code = order_code;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	// -------------------------------------------------------

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String insertThanhToanProcess() throws Exception {

		long id = new Date().getTime();
		long gia = (long) ((Cart) session.get("cart")).total();
		String sdt = ((Users) session.get("user")).getSdt();
		String ghichu = "";

		for (Map.Entry<Long, Item> i : ((Cart) session.get("cart")).getDsItem().entrySet())
			ghichu += i.getValue().getProduct().getTen() + "(" + i.getValue().getProduct().getId() + ")x"
					+ i.getValue().getQty() + "; ";

		new DonHangDAO().insert(new DonHang(id, gia, sdt, ghichu));

		url = "https://www.nganluong.vn/button_payment.php?receiver=hieuthien95@gmail.com&product_name=" + id
				+ "&price=" + (long) gia + "&comments=" + ghichu
				+ "&return_url=http://localhost:8081/ShopStruts2/update-thanh-toan";

		return SUCCESS;
	}

	public String updateThanhToanProcess() throws Exception {
		// http://localhost:8081/ShopStruts2/update-thanh-toan?comments=Galaxy%20Note%205(19)x1;&transaction_info=&order_code=1492271142994&price=2000&payment_id=28264931&payment_type=2&error_text=&secure_code=8ecd3d2bc2a96120cbdef2baaff5d561&token_nl=9354132-a8a01044de0a3ced1d6e16bc688f505e
		// http://localhost:8081/ShopStruts2/update-thanh-toan?comments=Galaxy%20Note%205(19)x1;&transaction_info=&order_code=1492271512644&price=2000&payment_id=28265069&payment_type=2&error_text=&secure_code=7acd2882d56ea078458df815a7a5475c&token_nl=9354224-55a1a5125be856a61f42e8fe31dced5b
		// http://localhost:8081/ShopStruts2/update-thanh-toan?transaction_info=&order_code=1492320664731&price=2000&payment_id=28271558&payment_type=2&error_text=&secure_code=a52a82f29a8d124c42eaa56614a73618&token_nl=9360701-a6e7b3c4c53c1e3a3ab7dc83fb44fd5d

		DonHang donhang = new DonHangDAO().getDonHangById(order_code);
		donhang.setMagiaodich(payment_id);

		new DonHangDAO().update(donhang);

		session.put("success", "Đã thanh toán thành công đơn hàng " + donhang.getId());
		return SUCCESS;
	}

}
