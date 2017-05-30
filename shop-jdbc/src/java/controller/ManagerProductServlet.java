/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
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
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author hieut
 */
public class ManagerProductServlet extends HttpServlet {

    String command = "insert", url = "", error = "", fileName = "";

    long product_id = 0, category_id = 0, product_price = 0;
    String product_name = "product_name";
    String product_image = "product_image";
    String product_description = "product_description";

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";

    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        command = request.getParameter("command");
        product_id = Long.parseLong(request.getParameter("product_id"));
        product_image = request.getParameter("product_image");

        switch (command) {
            case "delete":
                try {
                    deleteProductImage(product_id, product_image);
                } catch (SQLException ex) {
                }

                try {
                    new ProductDAO().deleteProduct(product_id);
                    url = "/shop-jdbc/admin/manager_product.jsp";
                    break;
                } catch (SQLException ex) {
                }
        }

        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long time = new Date().getSeconds() + new Date().getTime();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        List<FileItem> formItems = null;
        try {
            formItems = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            Logger.getLogger(ManagerProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                            // saves the file on disk
                            item.write(storeFile);
                        } catch (Exception ex) {
                            Logger.getLogger(ManagerProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        fileName = "";
                    }
                    request.setAttribute("message", UPLOAD_DIRECTORY + "/" + fileName);
                } else if (item.isFormField()) {
                    if (item.getFieldName().equals("command")) {
                        command = item.getString();
                    }
                    if (item.getFieldName().equals("category_id")) {
                        category_id = Long.parseLong(item.getString());
                    }
                    if (item.getFieldName().equals("product_name")) {
                        product_name = item.getString();
                    }
                    if (item.getFieldName().equals("product_price")) {
                        product_price = Long.parseLong(item.getString());
                    }
                    if (item.getFieldName().equals("product_description")) {
                        product_description = item.getString();
                    }
                    if (item.getFieldName().equals("product_id")) {
                        product_id = Long.parseLong(item.getString());
                    }
                    if (item.getFieldName().equals("product_image")) {
                        product_image = item.getString();
                    }

                    if (fileName.equals("")) {
                    } else {
                        product_image = UPLOAD_DIRECTORY + "/" + fileName;
                    }
                }

            }
        }

        switch (command) {
            case "insert":
                try {
                    new ProductDAO().insertProduct(new Product(0, category_id, product_name, product_image, product_price, product_description));
                    url = "/shop-jdbc/admin/manager_product.jsp";

                } catch (SQLException ex) {
                    request.setAttribute("message",
                            "There was an error: " + ex.getMessage());
                    url = "/shop-jdbc/admin/manager_product.jsp";
                }
                break;
            case "update":
                try {
                    new ProductDAO().updateProduct(new Product(product_id, category_id, product_name, product_image, product_price, product_description));
                    url = "/shop-jdbc/admin/manager_product.jsp";

                } catch (SQLException ex) {
                    request.setAttribute("message",
                            "There was an error: " + ex.getMessage());
                    url = "/shop-jdbc/admin/manager_product.jsp";
                }
                break;
        }

        response.sendRedirect(url);
    }

    public void deleteProductImage(long product_id, String product_image) throws SQLException {

        String filePath = getServletContext().getRealPath("")
                + File.separator + File.separator + product_image;
        File f = new File(filePath);
        f.delete();
    }

}
