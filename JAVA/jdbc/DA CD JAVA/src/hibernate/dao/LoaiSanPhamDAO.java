package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_LoaiSP;
import hibernate.model.LoaiSanPham;
import hibernate.util.HibernateUtil;



public class LoaiSanPhamDAO implements Interface_LoaiSP {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save((LoaiSanPham) obj);
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
			session.update((LoaiSanPham) obj);
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
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<LoaiSanPham> getAllLoaiSanPham() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<LoaiSanPham> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<LoaiSanPham>) session.createQuery("FROM LoaiSanPham ORDER BY stt ASC ").list();
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
		LoaiSanPhamDAO dao = new LoaiSanPhamDAO();

		System.out.println(dao.getAllLoaiSanPham());
		System.exit(0);
	}
}
