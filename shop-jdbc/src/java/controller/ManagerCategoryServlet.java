/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

public class ManagerCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String command = request.getParameter("command");
        Long category_id = Long.parseLong(request.getParameter("category_id"));

        String url = "", error = "";

        switch (command) {
            case "delete":
                try {
                    new CategoryDAO().deleteCategory(category_id);
                    url = "/shop-jdbc/admin/manager_category.jsp";
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(ManagerCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String command = request.getParameter("command");
        String category_name = request.getParameter("category_name");
        Long category_id = Long.parseLong(request.getParameter("category_id"));

        String url = "", error = "";

        if (category_name.equals("")) {
            error = "Chưa nhập tên danh mục";
            request.setAttribute("error", error);
            url = "/shop-jdbc/admin/insert_category.jsp";
        } else {
            switch (command) {
                case "insert":
                    try {
                        new CategoryDAO().insertCategory(new Category(new Date().getTime(), category_name));
                        url = "/shop-jdbc/admin/manager_category.jsp";
                        break;
                    } catch (SQLException ex) {
                        Logger.getLogger(ManagerCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                case "update":
                    try {
                        new CategoryDAO().updateCategory(new Category(category_id, category_name));
                        url = "/shop-jdbc/admin/manager_category.jsp";
                        break;
                    } catch (SQLException ex) {
                        Logger.getLogger(ManagerCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                        url = "/shop-jdbc/admin/manager_category.jsp";
                    }

            }
        }

        response.sendRedirect(url);

    }

}
