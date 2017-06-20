/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hieut
 */
public class UserService {
    
    @Autowired
    UserDAO userDAO;
    
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }
    
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public User getUser(int user_id) {
        return userDAO.getUser(user_id);
    }

    public User checkLogin(String username, String password) {
        return userDAO.checkLogin(username, password);
    }

    public boolean checkUsername(String username) {
        return userDAO.checkUsername(username);
    }
    
    public static void main(String[] args) {
        System.out.println(new UserService().checkLogin("admin", "123456"));
    }
    
}
