/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;
import tool.MD5;

/**
 *
 * @author hieut
 */
public class UsersServlet extends HttpServlet {

    UsersDAO usersDAO = new UsersDAO();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            String url = "";
            HttpSession session = request.getSession();
            Users users;
            switch (command) {
                case "insert":
                    users = new Users(new java.util.Date().getTime(), request.getParameter("email"), MD5.encryption(request.getParameter("password")), false);
                    usersDAO.insertUser(users);
                    session.setAttribute("user", users);
                    url = "/index.jsp";
                    break;
                case "login":
                    users = usersDAO.login(request.getParameter("email"), MD5.encryption(request.getParameter("password")));
                    if (users != null) {
                        url = "/index.jsp";
                        session.setAttribute("user", users);
                    }
                    else {
                        request.setAttribute("error", "Error email or password");
                        url = "/login.jsp";
                    }
                    break;
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(UsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
