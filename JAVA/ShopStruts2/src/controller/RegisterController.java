package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsersDAO;
import model.DonHang;
import model.Users;
import tool.MD5;

public class RegisterController extends ActionSupport
		implements SessionAware, ServletRequestAware, ServletContextAware {

	private static final long serialVersionUID = 1L;

	private File myFile;
	private String myFileFileName;
	private ServletContext servletContext;

	String url;
	private Users user;
	ArrayList<DonHang> dsdonhang;

	private Map<String, Object> session;
	private HttpServletRequest request;

	public RegisterController() {
		super();
	}

	public RegisterController(Map<String, Object> session, HttpServletRequest request) {
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

	@Override
	public void validate() {
		if (user.getName().trim().length() < 1)
			addFieldError("user.name", "Tên không được bỏ trống");
		if (user.getPassword().trim().length() < 6)
			addFieldError("user.password", "Password phải từ 6 ký tự");
		if (user.getSdt().trim().length() < 10)
			addFieldError("user.sdt", "Số điện thoại phải từ 10 ký tự");
		if (user.getEmail().trim().length() < 1)
			addFieldError("user.email", "Email không được bỏ trống");
		if (myFileFileName == null || myFileFileName.length() < 1)
			addFieldError("myFile", "Hãy đặt hình ảnh đại diện");
	}

}
