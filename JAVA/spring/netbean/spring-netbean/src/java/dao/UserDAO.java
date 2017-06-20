/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hieut
 */
public class UserDAO {

    public void insertUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(user);
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

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.merge(user);
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

    public User getUser(int user_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        User user = new User();

        try {
            tx = session.beginTransaction();
            user = (User) session.createQuery("FROM User WHERE user_id = '" + user_id + "'").uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return user;
    }

    public User checkLogin(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        User user;
        try {
            tx = session.beginTransaction();
            user = (User) session
                    .createQuery("FROM User WHERE username = '" + username + "' AND password = '" + password + "'")
                    .uniqueResult();
            tx.commit();

            if (user!=null) {
                return user;
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    public boolean checkUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        List<User> list = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            list = session.createQuery("FROM User WHERE username = '" + username + "'").list();
            tx.commit();

            if (list.size() >= 1) {
                return true;
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new UserDAO().checkLogin("admin", "123456"));

    }

}
