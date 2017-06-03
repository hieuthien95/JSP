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

import dao.VideoDAO;
import model.User;
import model.Video;

public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String ten = "";
	String hinhanh = "";
	int trangthai = 0;

	String duongdan = "";
	String noidung = "";
	int stt = 0;

	String UPLOAD_DIRECTORY = "website/view/video";
	String fileName = "";
	@SuppressWarnings("deprecation")
	long time = new Date().getSeconds() + new Date().getTime();
	int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public VideoServlet() {
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
			String ten = (String) request.getParameter("ten");
			String hinhanh = (String) request.getParameter("hinhanh");
			int trangthai = Integer.parseInt((String) request.getParameter("trangthai"));

			String duongdan = (String) request.getParameter("duongdan");
			String noidung = (String) request.getParameter("noidung");

			new VideoDAO().insert(new Video(0, ten, hinhanh, trangthai, duongdan, noidung));

			response.sendRedirect(request.getHeader("referer"));
			
			request.getSession().setAttribute("success", "Đã thêm video");
			return;
		case "remove":
			int stt = Integer.parseInt((String) request.getParameter("stt"));
			
			try {
				deleteImage(new VideoDAO().getVideoByStt(stt).getHinhanh());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			new VideoDAO().delete(stt);

			response.sendRedirect(request.getHeader("referer"));
			request.getSession().setAttribute("error", "Đã xóa video");
			return;

		case "update":
			ten = (String) request.getParameter("ten");
			hinhanh = (String) request.getParameter("hinhanh");
			trangthai = Integer.parseInt((String) request.getParameter("trangthai"));

			duongdan = (String) request.getParameter("duongdan");
			noidung = (String) request.getParameter("noidung");
			stt = Integer.parseInt((String) request.getParameter("stt"));

			new VideoDAO().update(new Video(stt, ten, hinhanh, trangthai, duongdan, noidung));

			response.sendRedirect(request.getHeader("referer"));
			request.getSession().setAttribute("success", "Đã cập nhật video");
			return;

		}
	}

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

						if (item.getFieldName().equals("ten")) {
							ten = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("hinhanh")) {
							hinhanh = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("trangthai")) {
							trangthai = Integer.parseInt(item.getString("UTF-8"));
						}

						if (item.getFieldName().equals("duongdan")) {
							duongdan = item.getString("UTF-8");
						}

						if (item.getFieldName().equals("noidung")) {
							noidung = item.getString("UTF-8");
						}

						if (!fileName.equals("")) {
							hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}

				}
			}
			// ----------------------------------------------------------------
			new VideoDAO().insert(new Video(0, ten, hinhanh, trangthai, duongdan, noidung));

			response.sendRedirect(request.getHeader("referer"));
			request.getSession().setAttribute("success", "Đã thêm video");
			return;

		// TODO
		case "update":
			stt = Integer.parseInt(request.getParameter("stt"));
			Video v = new VideoDAO().getVideoByStt(stt);

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

						if (item.getFieldName().equals("ten")) {
							ten = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("hinhanh")) {
							hinhanh = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("trangthai")) {
							trangthai = Integer.parseInt(item.getString("UTF-8"));
						}

						if (item.getFieldName().equals("duongdan")) {
							duongdan = item.getString("UTF-8");
						}

						if (item.getFieldName().equals("noidung")) {
							noidung = item.getString("UTF-8");
						}

						if (!fileName.equals("")) {
							hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
						}
					}

				}
			}
			// ----------------------------------------------------------------
			if (fileName.equals(""))
				new VideoDAO().update(new Video(stt, ten, v.getHinhanh(), trangthai, duongdan, noidung));
			else {
				try {
					deleteImage(v.getHinhanh());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				new VideoDAO().update(new Video(stt, ten, hinhanh, trangthai, duongdan, noidung));
			}
			// ----------------------------------------------------------------

			response.sendRedirect(request.getHeader("referer"));
			request.getSession().setAttribute("success", "Đã cập nhật video");
			return;
		}
	}

	public void deleteImage(String product_image) throws SQLException {
		String filePath = getServletContext().getRealPath("") + File.separator + File.separator + product_image;
		File f = new File(filePath);
		f.delete();
	}

}
