package dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import interfacce.Interface_HinhAnh;
import model.HinhAnh;
import util.HibernateUtil;

public class HinhAnhDAO implements Interface_HinhAnh {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save((HinhAnh) obj);
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
			session.update((HinhAnh) obj);
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
			session.delete(getHinhAnhById((int)id));
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
	public ArrayList<HinhAnh> getAllHinhAnh() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<HinhAnh> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<HinhAnh>) session.createQuery("FROM HinhAnh ORDER BY id DESC ").list();
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
	public HinhAnh getHinhAnhById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		HinhAnh anh = new HinhAnh();

		try {
			tx = session.beginTransaction();
			anh = (HinhAnh) session.createQuery("FROM HinhAnh WHERE id = " + id).uniqueResult();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return anh;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<HinhAnh> getAllHinhAnhByIdSP(int idSP) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<HinhAnh> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<HinhAnh>) session.createQuery("FROM HinhAnh WHERE idsp = " + idSP).list();
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
	
	public static void main(String[] args) {
		System.out.println(new HinhAnhDAO().getAllHinhAnh());
		
		System.exit(0);
	}
}
