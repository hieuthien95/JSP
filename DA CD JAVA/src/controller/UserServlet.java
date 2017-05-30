package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.UserDAO;
import model.User;
import tool.MD5;
import tool.SendMail;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String username = "";
	String email = "";
	String sdt = "";
	String ten = "";

	String password = "";
	String newpassword = "";
	String repassword = "";
	String avatar = "";
	String quyen = "";

	int stt = 0;

	String UPLOAD_DIRECTORY = "website/view/dangnhap";
	String fileName = "";
	@SuppressWarnings("deprecation")
	long time = new Date().getSeconds() + new Date().getTime();
	int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String command = request.getParameter("command");

		switch (command) {

		case "logout":
			session.removeAttribute("user");

			// remove cookie
			Cookie[] cookie = request.getCookies();
			for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("username") || cookie[i].getName().equals("password")) {
					cookie[i].setValue("");
					cookie[i].setPath("/");
					cookie[i].setMaxAge(0);
					response.addCookie(cookie[i]);
				}
			}

			session.setAttribute("error", "Đã đăng xuất");
			break;
		case "loginwithcookie":
			User user = new UserDAO().login(request.getParameter("username"), request.getParameter("password"));
			session.setAttribute("user", user);

			// response.sendRedirect(request.getHeader("referer"));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

			session.setAttribute("success", "Đăng nhập lại với cookie");
			return;
		case "forgot":
			String email = request.getParameter("email");
			user = new UserDAO().getUserByEmail(email);

			String newpass = "";
			for (int i = 0; i <= 6; i++)
				newpass += new Random().nextInt(99);

			boolean isSent = false;
			try {
				isSent = SendMail.sendMail(user.getEmail(), "Forgot password", newpass);
			} catch (Exception e) {
			}

			if (user != null) {
				user.setPassword(MD5.encryption(newpass));
				if (isSent)
					new UserDAO().update(user);

				session.setAttribute("success", "Mật khẩu mới đã được gửi đến ");
			} else {
				session.setAttribute("error", "Không tồn tại ");
			}
			break;
		}

		// RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		// rd.forward(request, response);
		response.sendRedirect(request.getHeader("referer"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		HttpSession session = request.getSession();

		User user;
		switch (command) {
		// TODO
		case "register":
			// ----------------------------------------------------------------
			if (!ServletFileUpload.isMultipartContent(request)) {
				// if not, we stop here
				PrintWriter writer = response.getWriter();
				writer.println("Error: Form must has enctype=multipart/form-data.");
				writer.flush();
				return;
			}

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MEMORY_THRESHOLD);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(MAX_REQUEST_SIZE);

			String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			List<FileItem> formItems = null;
			try {
				formItems = upload.parseRequest(request);
			} catch (FileUploadException ex) {
				Logger.getLogger(SanPhamServlet.class.getName()).log(Level.SEVERE, null, ex);
			}

			if (formItems != null && formItems.size() > 0) {
				// iterates over form's fields
				for (FileItem item : formItems) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						fileName = time + new File(item.getName()).getName();
						if (!new File(item.getName()).getName().equals("")) {
							String filePath = uploadPath + File.separator + fileName;
							File storeFile = new File(filePath);
							try {
								item.write(storeFile);
							} catch (Exception ex) {
								Logger.getLogger(SanPhamServlet.class.getName()).log(Level.SEVERE, null, ex);
							}
						} else {
							fileName = "";
						}
						request.setAttribute("success", UPLOAD_DIRECTORY + "/" + fileName);

					} else if (item.isFormField()) {
						if (item.getFieldName().equals("username")) {
							username = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("email")) {
							email = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("ten")) {
							ten = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("sdt")) {
							sdt = item.getString("UTF-8");
						}

						if (item.getFieldName().equals("avatar")) {
							avatar = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("password")) {
							password = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("repassword")) {
							repassword = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("quyen")) {
							quyen = item.getString("UTF-8");
						}

						if (!fileName.equals("")) {
							avatar = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}

				}
			}
			// ----------------------------------------------------------------

			if (!username.equals("") && !password.equals("") && !email.equals("") && !sdt.equals("")
					&& !ten.equals("")) {
				if (password.equals(repassword)) {
					if (new UserDAO().checUsername(username, email) == false) {
						new UserDAO().register(new User(0, username, sdt, email, ten, "Người dùng", avatar,
								MD5.encryption(password), 0));
						try {
							SendMail.sendMail(email, "DAJAVA", "Hello " + email + "\nYou sign up complete username: "
									+ username + ", password: " + password);
						} catch (Exception e) {
						}
						session.setAttribute("success", "Đăng ký thành công");
					} else {
						session.setAttribute("error", "Trùng username hoặc email");
						try {
							deleteImage(avatar);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				} else {
					session.setAttribute("error", "Không trùng mật khẩu");
				}
			} else {
				session.setAttribute("error", "Không được để trống dữ liệu nhập nào");
			}
			response.sendRedirect(request.getHeader("referer"));
			break;

		// TODO
		case "login":
			user = new UserDAO().login(request.getParameter("username"),
					MD5.encryption(request.getParameter("password")));
			if (user != null) {
				session.setAttribute("user", user);

				String remember = (String) request.getParameter("remember");
				if (remember != null && remember.equals("on")) {
					// add cookie
					Cookie cookieUsername = new Cookie("username", user.getUsername());
					cookieUsername.setMaxAge(60 * 60 * 96);
					Cookie cookiePassword = new Cookie("password", user.getPassword());
					cookiePassword.setMaxAge(60 * 60 * 96);
					response.addCookie(cookieUsername);
					response.addCookie(cookiePassword);
				}

				session.setAttribute("success", "Đăng nhập thành công");
			} else {
				session.setAttribute("error", "Error username or password");
			}

			response.sendRedirect(request.getHeader("referer"));
			break;
		// TODO
		case "update":
			user = (User) session.getAttribute("user");
			if (user != null) {
				stt = user.getStt();

				// ----------------------------------------------------------------

				if (!ServletFileUpload.isMultipartContent(request)) {
					// if not, we stop here
					PrintWriter writer = response.getWriter();
					writer.println("Error: Form must has enctype=multipart/form-data.");
					writer.flush();
					return;
				}

				factory = new DiskFileItemFactory();
				factory.setSizeThreshold(MEMORY_THRESHOLD);
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
				upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(MAX_FILE_SIZE);
				upload.setSizeMax(MAX_REQUEST_SIZE);

				uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
				uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}

				formItems = null;
				try {
					formItems = upload.parseRequest(request);
				} catch (FileUploadException ex) {
					Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
				}

				if (formItems != null && formItems.size() > 0) {
					// iterates over form's fields
					for (FileItem item : formItems) {
						// processes only fields that are not form fields
						if (!item.isFormField()) {
							fileName = time + new File(item.getName()).getName();
							if (!new File(item.getName()).getName().equals("")) {
								String filePath = uploadPath + File.separator + fileName;
								File storeFile = new File(filePath);
								try {
									item.write(storeFile);
								} catch (Exception ex) {
									Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
								}
							} else {
								fileName = "";
							}
							request.setAttribute("message", UPLOAD_DIRECTORY + "/" + fileName);

						} else if (item.isFormField()) {
							if (item.getFieldName().equals("email")) {
								email = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("ten")) {
								ten = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("sdt")) {
								sdt = item.getString("UTF-8");
							}

							if (item.getFieldName().equals("avatar")) {
								avatar = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("password")) {
								password = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("newpassword")) {
								newpassword = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("repassword")) {
								repassword = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("quyen")) {
								quyen = item.getString("UTF-8");
							}

							if (!fileName.equals("")) {
								avatar = UPLOAD_DIRECTORY + "/" + fileName;
							}
						}
					}
				}
				// ----------------------------------------------------------------

				if (!password.equals("") && !email.equals("") && !sdt.equals("") && !ten.equals("")) {
					if (MD5.encryption(password).equals(user.getPassword())) {
						if (!MD5.encryption(newpassword).equals("d41d8cd98f00b204e9800998ecf8427e")) {
							if (newpassword.equals(repassword)) {
								if (fileName.equals("")) {
									new UserDAO().update(new User(stt, user.getUsername(), sdt, email, ten, quyen,
											user.getAvatar(), MD5.encryption(newpassword), user.getDiemTichTuy()));

									session.setAttribute("success", "Cập nhật thành công");
									response.sendRedirect("/UserServlet?command=logout");
									return;
								} else {
									try {
										deleteImage(user.getAvatar());
									} catch (SQLException e) {
										e.printStackTrace();
									}
									new UserDAO().update(new User(stt, user.getUsername(), sdt, email, ten, quyen,
											avatar, MD5.encryption(newpassword), user.getDiemTichTuy()));
									response.sendRedirect("/UserServlet?command=logout");

									session.setAttribute("success", "Cập nhật thành công");
									return;
								}
							} else {
								session.setAttribute("error", "Nhập lại sai mật khẩu");
							}
						} else {
							if (fileName.equals("")) {
								new UserDAO().update(new User(stt, user.getUsername(), sdt, email, ten, quyen,
										user.getAvatar(), MD5.encryption(password), user.getDiemTichTuy()));

								session.setAttribute("success", "Cập nhật thành công");
								response.sendRedirect("/UserServlet?command=logout");
								return;
							} else {
								try {
									deleteImage(user.getAvatar());
								} catch (SQLException e) {
									e.printStackTrace();
								}
								new UserDAO().update(new User(stt, user.getUsername(), sdt, email, ten, quyen, avatar,
										MD5.encryption(password), user.getDiemTichTuy()));
								response.sendRedirect("/UserServlet?command=logout");

								session.setAttribute("success", "Cập nhật thành công");
								return;
							}
						}

					} else {
						session.setAttribute("error", "Sai mật khẩu");

					}
				} else {
					session.setAttribute("error", "Không được để trống dữ liệu nhập nào");
				}
				// ----------------------------------------------------------------
			}

			response.sendRedirect("/profile.jsp");
			return;

		}
	}

	public void deleteImage(String product_image) throws SQLException {
		String filePath = getServletContext().getRealPath("") + File.separator + File.separator + product_image;
		File f = new File(filePath);
		f.delete();
	}
}
