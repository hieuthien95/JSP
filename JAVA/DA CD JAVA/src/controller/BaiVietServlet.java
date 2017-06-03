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

import dao.BaiVietDAO;
import model.User;
import model.BaiViet;

public class BaiVietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String loaitin = "";
	String tieude = "";
	String tomtat = "";
	String hinhanh = "";
	String noidung = "";
	int trangthai = 0;
	int stt = 0;

	String UPLOAD_DIRECTORY = "website/view/tintuc";
	String fileName = "";
	@SuppressWarnings("deprecation")
	long time = new Date().getSeconds() + new Date().getTime();
	int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public BaiVietServlet() {
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

		String command = request.getParameter("command");

		switch (command) {
		case "insert":
			String loaitin = (String) request.getParameter("loaitin");
			String tieude = (String) request.getParameter("tieude");
			String tomtat = (String) request.getParameter("tomtat");
			String hinhanh = (String) request.getParameter("hinhanh");

			String noidung = (String) request.getParameter("noidung");
			int trangthai = Integer.parseInt((String) request.getParameter("trangthai"));

			new BaiVietDAO().insert(new BaiViet(0, loaitin, tieude, tomtat, hinhanh, noidung, trangthai));

			response.sendRedirect(request.getHeader("referer"));
			
			request.getSession().setAttribute("success", "Đã thêm bài viết");
			return;
		case "remove":
			int stt = Integer.parseInt((String) request.getParameter("stt"));
			
			try {
				deleteImage(new BaiVietDAO().getBaiVietByStt(stt).getHinhanh());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			new BaiVietDAO().delete(stt);

			response.sendRedirect(request.getHeader("referer"));
			
			request.getSession().setAttribute("error", "Đã xóa bài viết");
			return;

		case "update":
			loaitin = (String) request.getParameter("loaitin");
			tieude = (String) request.getParameter("tieude");
			tomtat = (String) request.getParameter("tomtat");
			hinhanh = (String) request.getParameter("hinhanh");

			noidung = (String) request.getParameter("noidung");
			trangthai = Integer.parseInt((String) request.getParameter("trangthai"));
			stt = Integer.parseInt((String) request.getParameter("stt"));

			new BaiVietDAO().update(new BaiViet(stt, loaitin, tieude, tomtat, hinhanh, noidung, trangthai));

			response.sendRedirect(request.getHeader("referer"));
			
			request.getSession().setAttribute("success", "Đã cập nhật bài viết");
			return;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		User sessionUser = (User) request.getSession().getAttribute("user");
		if(sessionUser == null || !sessionUser.getQuyen().equalsIgnoreCase("admin")
				&& !sessionUser.getQuyen().equalsIgnoreCase("Nhân viên")){
			
			response.sendRedirect(request.getHeader("referer"));
			return;
		}

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
						if (item.getFieldName().equals("loaitin")) {
							loaitin = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("tieude")) {
							tieude = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("tomtat")) {
							tomtat = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("hinhanh")) {
							hinhanh = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("noidung")) {
							noidung = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("trangthai")) {
							trangthai = Integer.parseInt(item.getString("UTF-8"));
						}
						
						if (!fileName.equals("")) {
							hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}

				}
			}
			// ----------------------------------------------------------------
			new BaiVietDAO().insert(new BaiViet(0, loaitin, tieude, tomtat, hinhanh, noidung, trangthai));

			response.sendRedirect(request.getHeader("referer"));
			
			request.getSession().setAttribute("success", "Đã thêm bài viết");
			return;

		// TODO ---------------------------------------------------------------
		case "update":
			stt = Integer.parseInt(request.getParameter("stt"));
			BaiViet bv = new BaiVietDAO().getBaiVietByStt(stt);

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
						if (item.getFieldName().equals("loaitin")) {
							loaitin = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("tieude")) {
							tieude = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("tomtat")) {
							tomtat = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("hinhanh")) {
							hinhanh = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("noidung")) {
							noidung = item.getString("UTF-8");
						}
						
						if (item.getFieldName().equals("trangthai")) {
							trangthai = Integer.parseInt(item.getString("UTF-8"));
						}
						
						if (!fileName.equals("")) {
							hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}
				}
			}
			// ----------------------------------------------------------------
			if (fileName.equals(""))
				new BaiVietDAO().update(new BaiViet(stt, loaitin, tieude, tomtat, bv.getHinhanh(), noidung, trangthai));
			else {
				try {
					deleteImage(bv.getHinhanh());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				new BaiVietDAO().update(new BaiViet(stt, loaitin, tieude, tomtat, hinhanh, noidung, trangthai));
			}
			// ----------------------------------------------------------------

			response.sendRedirect(request.getHeader("referer"));
			
			request.getSession().setAttribute("success", "Đã cập nhật bài viết");
			return;
		}
	}
	
	public void deleteImage(String product_image) throws SQLException {
		String filePath = getServletContext().getRealPath("") + File.separator + File.separator + product_image;
		File f = new File(filePath);
		f.delete();
	}

}
