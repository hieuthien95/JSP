package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_DonHang;
import hibernate.model.DonHang;
import hibernate.util.HibernateUtil;

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
	public boolean delete(long stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(getDonHangByStt((long) stt));
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
			list = (ArrayList<DonHang>) session.createQuery("FROM DonHang ORDER BY stt DESC ").list();
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
	public DonHang getDonHangByStt(long sott) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		DonHang donHang = new DonHang();
		try {
			tx = session.beginTransaction();
			donHang = (DonHang) session.createQuery("FROM DonHang WHERE stt = " + sott).uniqueResult();
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
		DonHangDAO dao = new DonHangDAO();
		 System.out.println(dao.getAllDonHang());
		// System.out.println(dao.getAllDonHangBySdt("01293245504"));
		// System.out.println(dao.getDonHangByStt(Long.parseLong("1489935989337")));

		// dao.insert(new DonHang(0, 0, "sdt", "ghiChu", "maGiaoDich",
		// "thoiGian"));
		//
		// DonHang donHang =
		// dao.getDonHangByStt(Long.parseLong("1489937312118"));
		// donHang.setGhiChu("000000000000");
		// dao.update(donHang);

//		dao.delete(Long.parseLong("1489937312118"));

		System.exit(0);
	}
}
