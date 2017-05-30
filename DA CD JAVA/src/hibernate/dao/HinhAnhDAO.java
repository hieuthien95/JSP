package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_HinhAnh;
import hibernate.model.HinhAnh;
import hibernate.util.HibernateUtil;



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
	public boolean delete(long stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(getHinhAnhByStt((int)stt));
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
			list = (ArrayList<HinhAnh>) session.createQuery("FROM HinhAnh ORDER BY stt DESC ").list();
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
	public HinhAnh getHinhAnhByStt(int stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		HinhAnh anh = new HinhAnh();

		try {
			tx = session.beginTransaction();
			anh = (HinhAnh) session.createQuery("FROM HinhAnh WHERE stt = " + stt).uniqueResult();
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
	public ArrayList<HinhAnh> getAllHinhAnhBySttSP(int sttSP) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<HinhAnh> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<HinhAnh>) session.createQuery("FROM HinhAnh WHERE sttsp = " + sttSP).list();
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
		HinhAnhDAO dao = new HinhAnhDAO();

		// System.out.println(dao.getAllHinhAnh());
		// System.out.println(dao.getHinhAnhBySttSP(21));
		// System.out.println(dao.getAllHinhAnhBySttSP(26));

//		dao.insert(new HinhAnh(0, "loaiHinh", 11, "hinhAnh"));

		// HinhAnh ha = dao.getHinhAnhByStt(193);
		// ha.setHinhAnh("000");
		// dao.update(ha);
		
		dao.delete(195);

		System.exit(0);
	}

}
