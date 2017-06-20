/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CartService;

/**
 *
 * @author hieut
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, HttpServletResponse response, ModelMap mm) {

        Long productID = Long.parseLong(request.getParameter("productID"));

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        Product product = new ProductDAO().getProductByID(productID);

        if (cart != null) {
            cart.doCart(productID, new Item(product, 1));
        } else {
            cart = new Cart();
            cart.doCart(productID, new Item(product, 1));
        }

        session.setAttribute("cart", cart);
       return "redirect:/home/index";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(HttpServletRequest request, HttpServletResponse response, ModelMap mm) {
        Long productID = Long.parseLong(request.getParameter("productID"));

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        Product product = new ProductDAO().getProductByID(productID);

        if (cart != null) {
            cart.removeToCart(productID);
        } 

        session.setAttribute("cart", cart);
        return "redirect:/cart/detail";
    }
    
    @RequestMapping(value = "/detail")
    public String add(HttpServletRequest request, ModelMap mm) {
        return "pages/cart";
    }

}
