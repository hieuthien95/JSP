package dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;
import interfacce.Interface_Users;
import model.Users;
import tool.MD5;

public class UsersDAO implements Interface_Users {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		return false;
	}

	@Override
	public boolean update(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update((Users) obj);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(getUserById((int) id));
			tx.commit();
			return true;
		} catch (HibernateException e) {
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
	public ArrayList<Users> getAllUsers() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<Users> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<Users>) session.createQuery("FROM Users ORDER BY id DESC").list();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public boolean checUsername(String name, String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Users user = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Users WHERE name = :name OR email = :email");
			query.setString("name", name);
			query.setString("email", email);
			user = (Users) query.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return user != null;
	}

	@Override
	public boolean register(Users user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Users login(String email, String password) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Users user = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Users WHERE email = :email AND password = :password");
			query.setString("email", email);
			query.setString("password", password);
			user = (Users) query.uniqueResult();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public Users getUserById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Users user = new Users();
		try {
			tx = session.beginTransaction();
			user = (Users) session.createQuery("FROM Users WHERE id = " + id).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public Users getUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Users user = new Users();
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Users WHERE email = :email");
			query.setString("email", email);
			user = (Users) query.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return user;
	}
	
	public static void main(String[] args) {
		Users user = new UsersDAO().login("root@gmail.com", MD5.encryption("admin"));
		user.setPassword("123456");
		
		System.out.println(new UsersDAO().update(user));
	}
}
