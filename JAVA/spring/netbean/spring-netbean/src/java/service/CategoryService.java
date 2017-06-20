/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CategoryDAO;
import java.util.ArrayList;
import model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import util.HibernateUtil;

/**
 *
 * @author hieut
 */
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public ArrayList<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }
}
