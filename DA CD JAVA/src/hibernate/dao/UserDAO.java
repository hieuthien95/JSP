package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_User;
import hibernate.model.User;
import hibernate.util.HibernateUtil;

public class UserDAO implements Interface_User {
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
			session.update((User) obj);
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
	public boolean delete(long stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(getUserByStt((int) stt));
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
	public ArrayList<User> getAllUser() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<User> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<User>) session.createQuery("FROM User ORDER BY stt DESC").list();
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
	public boolean checUsername(String username, String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE username = :username OR email = :email");
			query.setString("username", username);
			query.setString("email", email);
			user = (User) query.uniqueResult();
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
	public boolean register(User user) {
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
	public User login(String username, String password) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE username = :username AND password = :password");
			query.setString("username", username);
			query.setString("password", password);
			user = (User) query.uniqueResult();

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
	public User getUserByStt(int stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = new User();
		try {
			tx = session.beginTransaction();
			user = (User) session.createQuery("FROM User WHERE stt = " + stt).uniqueResult();
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
	public User getUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User user = new User();
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE email = :email");
			query.setString("email", email);
			user = (User) query.uniqueResult();
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
		UserDAO dao = new UserDAO();
		// dao.register(new User(0, "username", "sdt", "email", "ten", "quyen",
		// "avatar", "password", 0));
		//
		// User user = dao.getUserByStt(76);
		// user.setDiemTichTuy(1000);
		// dao.update(user);

		// dao.delete(76);

		// System.out.println(dao.getAllUser());
		// System.out.println(dao.checUsername("", "tramdo1610@gmail.com"));

		System.out.println(dao.getUserByEmail("hieuthien95@gmail.com"));

		System.exit(0);
	}
}
