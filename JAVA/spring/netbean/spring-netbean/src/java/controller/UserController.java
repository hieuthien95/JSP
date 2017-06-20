/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

/**
 *
 * @author hieut
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService = new UserService();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap mm) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String error;
        if (userService.checkLogin(username, password) == null) {
            error = "Sai tên đăng nhập hoặc mật khẩu";
            request.setAttribute("error", error);
            mm.put("error", error);
            return "pages/login";
        }
        else {
            User user = userService.checkLogin(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response, ModelMap mm) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String error;
        if (userService.checkUsername(username) == true) {
            error = "Tên này đã có người dùng";
            mm.put("error", error);
            return "pages/register";
        } else {
            userService.insertUser(new User(0, username, password, 0));
            return "redirect:/index";
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, HttpServletResponse response, ModelMap mm) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String error;
        if (userService.checkUsername(username) == true) {
            error = "Tên này đã có người dùng";
            mm.put("error", error);
            return "pages/register";
        } else {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            int user_id = user.getUser_id();
            userService.updateUser(new User(user_id, username, password, 0));
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap mm) {
        HttpSession session = request.getSession();
        session.setAttribute("username", null);
        return "redirect:/index";
    }
}
