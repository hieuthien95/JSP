package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_HangSX;
import hibernate.model.HangSanXuat;
import hibernate.util.HibernateUtil;

public class HangSanXuatDAO implements Interface_HangSX {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save((HangSanXuat) obj);
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
	public boolean update(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update((HangSanXuat) obj);
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

		try {
			String hql = "DELETE FROM HangSanXuat WHERE stt = :stt";
			Query query = session.createQuery(hql);
			query.setInteger("stt", (int) stt);
			int result = query.executeUpdate();
			return result >= 1;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<HangSanXuat> getAllHangSX() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<HangSanXuat> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<HangSanXuat>) session.createQuery("FROM HangSanXuat").list();
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
	public HangSanXuat getHangSXByStt(int stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		HangSanXuat hsx = new HangSanXuat();
		try {
			tx = session.beginTransaction();
			hsx = (HangSanXuat) session.createQuery("FROM HangSanXuat WHERE stt = " + stt).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return hsx;
	}

	public static void main(String[] args) {
		HangSanXuatDAO dao = new HangSanXuatDAO();
		System.out.println(dao.getAllHangSX());

		System.exit(0);
	}
}
