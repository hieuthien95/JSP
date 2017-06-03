package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.SanPhamDAO;
import model.User;
import model.SanPham;

public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String hinhanh = "";
	String ten = "";
	int gia = 0;
	String manhinh = "";
	String hdh = "";

	String cpu = "";
	String camera = "";
	String pin = "";
	String nhieuhon = "";
	String hangsx = "";

	String loaisp = "";
	String km = "";
	int trangthai = 0;
	String sl = "";
	int stt = 0;

	String UPLOAD_DIRECTORY = "website/view/hanghoa";
	String fileName = "";
	@SuppressWarnings("deprecation")
	long time = new Date().getSeconds() + new Date().getTime();
	int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public SanPhamServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		User sessionUser = (User) request.getSession().getAttribute("user");
		if(sessionUser == null || !sessionUser.getQuyen().equalsIgnoreCase("admin")
				&& !sessionUser.getQuyen().equalsIgnoreCase("Nhân viên")){
			
			response.sendRedirect(request.getHeader("referer"));
			return;
		}

		request.setCharacterEncoding("utf-8");

		String command = request.getParameter("command");

		if (command != null)
			switch (command) {

			case "insert":
				hinhanh = (String) request.getParameter("hinhanh");
				ten = (String) request.getParameter("ten");
				gia = Integer.parseInt((String) request.getParameter("gia"));
				manhinh = (String) request.getParameter("manhinh");
				hdh = (String) request.getParameter("hdh");

				cpu = (String) request.getParameter("cpu");
				camera = (String) request.getParameter("camera");
				pin = (String) request.getParameter("pin");
				nhieuhon = (String) request.getParameter("nhieuhon");
				hangsx = (String) request.getParameter("hangsx");

				loaisp = (String) request.getParameter("loaisp");
				km = (String) request.getParameter("km");
				trangthai = Integer.parseInt((String) request.getParameter("trangthai"));
				sl = (String) request.getParameter("sl");

				new SanPhamDAO().insert(new SanPham(0, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon,
						hangsx, loaisp, km, trangthai, sl));

				response.sendRedirect(request.getHeader("referer"));
				
				request.getSession().setAttribute("success", "Đã thêm sản phẩm");
				return;

			case "remove":
				stt = Integer.parseInt((String) request.getParameter("stt"));
				
				try {
					deleteImage(new SanPhamDAO().getSanPhamByStt(stt).getHinhanh());
				} catch (SQLException e) {
					e.printStackTrace();
				}

				new SanPhamDAO().delete(stt);

				response.sendRedirect(request.getHeader("referer"));
				
				request.getSession().setAttribute("error", "Đã xóa sản phẩm");
				return;

			case "update":
				hinhanh = (String) request.getParameter("hinhanh");
				ten = (String) request.getParameter("ten");
				gia = Integer.parseInt((String) request.getParameter("gia"));
				manhinh = (String) request.getParameter("manhinh");
				hdh = (String) request.getParameter("hdh");

				cpu = (String) request.getParameter("cpu");
				camera = (String) request.getParameter("camera");
				pin = (String) request.getParameter("pin");
				nhieuhon = (String) request.getParameter("nhieuhon");
				hangsx = (String) request.getParameter("hangsx");

				loaisp = (String) request.getParameter("loaisp");
				km = (String) request.getParameter("km");
				trangthai = Integer.parseInt((String) request.getParameter("trangthai"));
				sl = (String) request.getParameter("sl");
				stt = Integer.parseInt((String) request.getParameter("stt"));

				new SanPhamDAO().update(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon,
						hangsx, loaisp, km, trangthai, sl));

				response.sendRedirect(request.getHeader("referer"));
				
				request.getSession().setAttribute("success", "Đã cập nhật sản phẩm");
				return;

			}
	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User sessionUser = (User) request.getSession().getAttribute("user");
		if(sessionUser == null || !sessionUser.getQuyen().equalsIgnoreCase("admin")
				&& !sessionUser.getQuyen().equalsIgnoreCase("Nhân viên")){
			
			response.sendRedirect(request.getHeader("referer"));
			return;
		}

		request.setCharacterEncoding("utf-8");

		String comand = request.getParameter("command");
		switch (comand) {
		// TODO ---------------------------------------------------------------
		case "insert":
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
						request.setAttribute("message", UPLOAD_DIRECTORY + "/" + fileName);

					} else if (item.isFormField()) {
						if (item.getFieldName().equals("hinhanh")) {
							hinhanh = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("ten")) {
							ten = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("gia")) {
							String s = item.getString("UTF-8");
							if (s != null && !s.equals(""))
								gia = Integer.parseInt(s);
							else
								gia = 0;
						}
						if (item.getFieldName().equals("manhinh")) {
							manhinh = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("hdh")) {
							hdh = item.getString("UTF-8");
						}

						if (item.getFieldName().equals("cpu")) {
							cpu = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("camera")) {
							camera = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("pin")) {
							pin = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("nhieuhon")) {
							nhieuhon = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("hangsx")) {
							hangsx = item.getString("UTF-8");
						}

						if (item.getFieldName().equals("loaisp")) {
							loaisp = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("km")) {
							km = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("trangthai")) {
							trangthai = Integer.parseInt(item.getString());
						}
						if (item.getFieldName().equals("sl")) {
							sl = item.getString("UTF-8");
						}

						if (!fileName.equals("")) {
							hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}

				}
			}
			// ----------------------------------------------------------------
			new SanPhamDAO().insert(new SanPham(0, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx,
					loaisp, km, trangthai, sl));

			response.sendRedirect(request.getHeader("referer"));

			request.getSession().setAttribute("success", "Đã thêm sản phẩm");
			return;

		// TODO ---------------------------------------------------------------
		case "update":
			stt = Integer.parseInt(request.getParameter("stt"));
			SanPham sp = new SanPhamDAO().getSanPhamByStt((int) stt);

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
						request.setAttribute("message", UPLOAD_DIRECTORY + "/" + fileName);

					} else if (item.isFormField()) {
						if (item.getFieldName().equals("hinhanh")) {
							hinhanh = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("ten")) {
							ten = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("gia")) {
							String s = item.getString("UTF-8");
							if (s != null && !s.equals(""))
								gia = Integer.parseInt(s);
							else
								gia = 0;
						}
						if (item.getFieldName().equals("manhinh")) {
							manhinh = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("hdh")) {
							hdh = item.getString("UTF-8");
						}

						if (item.getFieldName().equals("cpu")) {
							cpu = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("camera")) {
							camera = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("pin")) {
							pin = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("nhieuhon")) {
							nhieuhon = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("hangsx")) {
							hangsx = item.getString("UTF-8");
						}

						if (item.getFieldName().equals("loaisp")) {
							loaisp = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("km")) {
							km = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("trangthai")) {
							trangthai = Integer.parseInt(item.getString());
						}
						if (item.getFieldName().equals("sl")) {
							sl = item.getString("UTF-8");
						}

						if (!fileName.equals("")) {
							hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}
				}
			}
			// ----------------------------------------------------------------
			if (fileName.equals(""))
				new SanPhamDAO().update(new SanPham(stt, sp.getHinhanh(), ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon,
						hangsx, loaisp, km, trangthai, sl));
			else {
				try {
					deleteImage(sp.getHinhanh());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				new SanPhamDAO().update(new SanPham(stt, hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon,
						hangsx, loaisp, km, trangthai, sl));
			}
			// ----------------------------------------------------------------

			response.sendRedirect(request.getHeader("referer"));
			
			request.getSession().setAttribute("success", "Đã cập nhật sản phẩm");
			return;

		// TODO ---------------------------------------------------------------
		case "updatehinhanh":
			stt = Integer.parseInt(request.getParameter("stt"));
			sp = new SanPhamDAO().getSanPhamByStt((int) stt);

			String UPLOAD_DIRECTORY = "website/view/hanghoa";
			String fileName = "", hinhanh = "";
			long time = new Date().getSeconds() + new Date().getTime();
			int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
			int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
			int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

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
						request.setAttribute("message", UPLOAD_DIRECTORY + "/" + fileName);

					} else if (item.isFormField()) {
						if (item.getFieldName().equals("hinhanh")) {
							hinhanh = item.getString();
						}

						// if (item.getFieldName().equals("ten")) {
						// ten = item.getString();
						// }

						if (!fileName.equals("")) {
							hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}

				}
			}

			// ----------------------------------------------------------------
			// Đặc biệt xóa phải bằng GET
			// xóa hình củ trước khi thêm
			try {
				deleteImage(sp.getHinhanh());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// ----------------------------------------------------------------
			sp.setHinhanh(hinhanh);
			new SanPhamDAO().update(sp);
			break;

		}

		response.sendRedirect(request.getHeader("referer"));
		request.getSession().setAttribute("success", "Đã cập nhật hình ảnh sản phẩm");
		return;
	}

	public void deleteImage(String product_image) throws SQLException {
		String filePath = getServletContext().getRealPath("") + File.separator + File.separator + product_image;
		File f = new File(filePath);
		f.delete();
	}

}
