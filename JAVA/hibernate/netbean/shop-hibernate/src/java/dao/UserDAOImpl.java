package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public User getUser(int user_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = new User();

		try {
			tx = session.beginTransaction();
			user = (User) session.createQuery("FROM User WHERE user_id = '" + user_id + "'").uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkLogin(String username, String password) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<User> list = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			list = session
					.createQuery("FROM User WHERE username = '" + username + "' AND password = '" + password + "'")
					.list();
			tx.commit();

			if (list.size() >= 1)
				return true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkUsername(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<User> list = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM User WHERE username = '" + username + "'").list();
			tx.commit();

			if (list.size() >= 1)
				return true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	public static void main(String[] args) {
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		System.out.println(userDAOImpl.checkLogin("hieuthien95", "thienthien"));
	}
}
