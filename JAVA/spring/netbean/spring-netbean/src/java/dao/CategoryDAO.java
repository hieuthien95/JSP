/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hieut
 */
public class CategoryDAO {

    public void insertCategory(Category c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(c);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

    }

    public ArrayList<Category> getAllCategory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM category");
        ArrayList<Category> list = (ArrayList<Category>) query.list();
        tx.commit();
        return list;
    }

    public ArrayList<Category> getChildCategory(int categoryID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM category WHERE categoryParent = '" + categoryID + "'");
        ArrayList<Category> list = (ArrayList<Category>) query.list();
        tx.commit();
        return list;
    }

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
//        for (int i = 1; i <= 15; i++) {
//            categoryDAO.insertCategory(new Category(0, "Category " + i, 0));
//        }

       System.out.println(categoryDAO.getAllCategory());
    }
}
