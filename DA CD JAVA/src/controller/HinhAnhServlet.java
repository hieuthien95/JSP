package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.HinhAnhDAO;
import model.User;
import model.HinhAnh;

public class HinhAnhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String command = "", url = "", fileName = "";

	long stt = 0;
	String hinhanh = "";

	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "website/view/hinhanh";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	public HinhAnhServlet() {
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
		
		String url = "";

		String command = request.getParameter("command");

		switch (command) {
		case "insert":
			break;
		// TODO
		case "remove":
			int stt = Integer.parseInt((String) request.getParameter("stt"));

			try {
				hinhanh = new HinhAnhDAO().getHinhAnhByStt(stt).getHinhAnh();
				
				// xóa ảnh củ trong thư mục
				deleteImage(hinhanh);

				// xóa CSDL
				new HinhAnhDAO().delete(stt);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getHeader("referer"));
			request.getSession().setAttribute("error", "Đã xóa hình ảnh sản phẩm");
			return;

		case "update":
			break;

		}
		response.sendRedirect(url);
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

		// -----------------------------------------------------------------------
		long time = new Date().getSeconds() + new Date().getTime();

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
			Logger.getLogger(HinhAnhServlet.class.getName()).log(Level.SEVERE, null, ex);
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
							Logger.getLogger(HinhAnhServlet.class.getName()).log(Level.SEVERE, null, ex);
						}
					} else {
						fileName = "";
					}
					request.setAttribute("message", UPLOAD_DIRECTORY + "/" + fileName);

				} else if (item.isFormField()) {
					if (item.getFieldName().equals("stt")) {
						stt = Long.parseLong(item.getString());
					}
					if (item.getFieldName().equals("hinhanh")) {
						hinhanh = item.getString();
					}

					if (!fileName.equals("")) {
						hinhanh = UPLOAD_DIRECTORY + "/" + fileName;
					} 
				}

			}
		}
		// /----------------------------------------------------------------------

		command = request.getParameter("command");
		switch (command) {
		// TODO
		case "insert":
			//
			new HinhAnhDAO().insert(new HinhAnh(0, "hanghoa", (int) stt, hinhanh));
			url = "/shop-jdbc/admin/manager_product.jsp";

			response.sendRedirect(request.getHeader("referer"));
			request.getSession().setAttribute("success", "Đã thêm hình ảnh sản phẩm");
			return;
		}

	}

	public void deleteImage(String product_image) throws SQLException {
		String filePath = getServletContext().getRealPath("") + File.separator + File.separator + product_image;
		File f = new File(filePath);
		f.delete();
	}

}
