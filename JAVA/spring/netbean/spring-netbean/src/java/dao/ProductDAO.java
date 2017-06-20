/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Category;
import model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hieut
 */
public class ProductDAO {

    public void insertProduct(Product p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(p);
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

    public ArrayList<Product> getAllProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Product> list = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            list = (ArrayList<Product>) session.createQuery("FROM product ORDER BY RAND()").setMaxResults(6).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public Product getProductByID(long productID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Product p = new Product();
        try {
            tx = session.beginTransaction();
            p = (Product) session.createQuery("FROM product WHERE productID = '" + productID + "'").uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return p;
    }

    public ArrayList<Product> getAllProductByCategory(long categoryID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Product> list = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            list = (ArrayList<Product>) session.createQuery("FROM product WHERE categoryID = '" + categoryID + "'").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return list;
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

//        for (Category i : new CategoryDAO().getAllcategory()) {
//            if (i.getCategoryID() == 1) {
//                for (int j = 0; j < 10; j++) {
//                    productDAO.insertProduct(new Product(0, i, "product " + j, "image " + j, 8, "description " + j));
//                }
//            }
//        }
        System.out.println(productDAO.getAllProduct().size());
    }

}
