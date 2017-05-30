package dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;
import interfacce.Interface_DonHang;
import model.DonHang;

public class DonHangDAO implements Interface_DonHang {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save((DonHang) obj);
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
			session.update((DonHang) obj);
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
			session.delete(getDonHangById((long) id));
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
	public ArrayList<DonHang> getAllDonHang() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<DonHang> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<DonHang>) session.createQuery("FROM DonHang ORDER BY id DESC ").list();
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
	public DonHang getDonHangById(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		DonHang donHang = new DonHang();
		try {
			tx = session.beginTransaction();
			donHang = (DonHang) session.createQuery("FROM DonHang WHERE id = " + id).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return donHang;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<DonHang> getAllDonHangBySdt(String sdt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<DonHang> donHangs = new ArrayList<DonHang>();
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM DonHang WHERE sdt = :sdt");
			query.setString("sdt", sdt);
			donHangs = (ArrayList<DonHang>) query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return donHangs;
	}
	
	public static void main(String[] args) {
		System.out.println(new DonHangDAO().getAllDonHangBySdt("01293245504"));
	}

}
