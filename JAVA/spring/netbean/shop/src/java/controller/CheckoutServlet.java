/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.BillDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.Item;
import model.Users;
import tool.SendMail;

/**
 *
 * @author hieut
 */
public class CheckoutServlet extends HttpServlet {

    private BillDAO billDAO = new BillDAO();
    private BillDetailDAO billDetailDAO = new BillDetailDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String payment = request.getParameter("payment");
            String address = request.getParameter("address");
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            Users users = (Users) session.getAttribute("user");
            long ID = new Date().getTime();

            Bill bill = new Bill(ID, users.getUserID(), cart.total(), payment, address, new Timestamp(new Date().getTime()));

            billDAO.insertBill(bill);

            for (Map.Entry<Long, Item> list : cart.getCartItems().entrySet()) {
                billDetailDAO.insertBillDetail(new BillDetail(0, ID,
                        list.getValue().getProduct().getProductID(),
                        list.getValue().getProduct().getProductPrice(),
                        list.getValue().getQuantity()
                ));
            }

            new SendMail().sendMail(users.getUserEmail(), "Website JSP", "Hello "+ users.getUserEmail() + "\nTotal $" + cart.total());
            
            cart = new Cart();
            session.setAttribute("cart", cart);

        } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("/shop/index.jsp");
        }

        response.sendRedirect("/shop/index.jsp");

    }

}
