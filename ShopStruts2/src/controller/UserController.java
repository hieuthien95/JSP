package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.DonHangDAO;
import dao.UsersDAO;
import model.DonHang;
import model.Users;
import tool.MD5;
import tool.SendMail;

public class UserController extends ActionSupport implements SessionAware, ServletRequestAware, ServletContextAware {

	private static final long serialVersionUID = 1L;

	private File myFile;
	private String myFileFileName;
	private ServletContext servletContext;

	String url;
	private Users user;
	ArrayList<DonHang> dsdonhang;

	private Map<String, Object> session;
	private HttpServletRequest request;

	public UserController() {
		super();
	}

	public UserController(Map<String, Object> session, HttpServletRequest request) {
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

	public ArrayList<DonHang> getDsdonhang() {
		return dsdonhang;
	}

	public void setDsdonhang(ArrayList<DonHang> dsdonhang) {
		this.dsdonhang = dsdonhang;
	}

	@Override
	public void setServletContext(ServletContext context) {
		servletContext = context;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	// User -------------------------------------------------------

	public String getLogin() throws Exception {
		// request.getSession().getAttribute("user") != null
		if (session.containsKey("user")) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String getProfile() throws Exception {
		if (session.containsKey("user")) {
			dsdonhang = new DonHangDAO().getAllDonHangBySdt(((Users) session.get("user")).getSdt());
			return SUCCESS;
		} else {
			session.put("error", "Bạn chưa đăng nhập");
			return ERROR;
		}
	}

	public String loginProcess() throws Exception {
		url = request.getHeader("referer");

		user = new UsersDAO().login(user.getEmail(), MD5.encryption(user.getPassword()));
		if (user == null) {
			session.put("error", "Đăng nhập thất bại");
			return ERROR;
		} else {
			// request.getSession().setAttribute("user", user);
			session.put("user", user);
			session.put("success", "Đăng nhập thành công");
			return SUCCESS;
		}
	}

	public String logoutProcess() throws Exception {
		if (session.containsKey("user"))
			// request.getSession().removeAttribute("user");
			session.remove("user");

		session.put("error", "Đã đăng xuất");
		return SUCCESS;
	}

	public String registerProcess() throws Exception {
		user.setPassword(MD5.encryption(user.getPassword()));
		user.setHinhanh(myFileFileName);

		if (new UsersDAO().register(user)) {
			try {
				String filePath = servletContext.getRealPath("/").concat("resource/public/upload/taikhoan");
				File destFile = new File(filePath, myFileFileName);
				FileUtils.copyFile(myFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			session.put("success", "Đăng ký thành công");
			return SUCCESS;
		} else {
			session.put("error", "Đăng ký thất bại");
			return ERROR;
		}

	}

	public String changeInfoProcess() throws Exception {
		Users user_old = (Users) session.get("user");

		if (user_old.getPassword().equals(MD5.encryption(user.getPassword()))) {
			String img_old = user_old.getHinhanh();

			user_old.setName(user.getName());
			user_old.setSdt(user.getSdt());
			user_old.setHinhanh(myFileFileName);
			// user_old.setPassword(MD5.encryption(user.getPassword()));

			if (new UsersDAO().update(user_old)) {
				try {
					String filePath = servletContext.getRealPath("/").concat("resource/public/upload/taikhoan");
					File destFile = new File(filePath, img_old);
					FileUtils.forceDelete(destFile);
				} catch (IOException e) {
				}
				try {
					String filePath = servletContext.getRealPath("/").concat("resource/public/upload/taikhoan");
					File destFile = new File(filePath, myFileFileName);
					FileUtils.copyFile(myFile, destFile);
				} catch (Exception e) {
				}

				session.put("success", "Cập nhật thành công");
				return SUCCESS;
			}
		} else {
			session.put("error", "Sai mật khẩu");
			return ERROR;
		}
		session.put("error", "Cập nhật thất bại");
		return ERROR;

	}

	public String forgetProcess() throws Exception {
		String mk = "";
		for (int i = 0; i < 8; i++)
			mk += new Random().nextInt(99);

		try {
			Users user_old = new UsersDAO().getUserByEmail(user.getEmail());
			user_old.setPassword(MD5.encryption(mk));
			new UsersDAO().update(user_old);

			SendMail.sendMail(user.getEmail(), "Quên mật khẩu", mk);
		} catch (Exception e) {
			session.put("error", "Thất bại");
			return ERROR;
		}

		session.put("success", "Đã gửi mật khẩu qua Mail của bạn");
		return SUCCESS;
	}

}
