package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_SanPham;
import hibernate.model.SanPham;
import hibernate.util.HibernateUtil;

public class SanPhamDAO implements Interface_SanPham {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save((SanPham) obj);
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
			session.update((SanPham) obj);
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
			String hql = "DELETE FROM SanPham WHERE stt = :stt";
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
	public ArrayList<SanPham> getAllSanPham() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<SanPham> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<SanPham>) session.createQuery("FROM SanPham ORDER BY stt DESC ").list();
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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SanPham> getAllSanPham(int min, int max) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<SanPham> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			Query query = session
					.createQuery("FROM SanPham sp WHERE sp.gia >= :min AND sp.gia <= :max ORDER BY gia ASC");
			query.setInteger("min", min);
			query.setInteger("max", max);
			list = (ArrayList<SanPham>) query.list();
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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SanPham> getSanPhamByLoai(String loai) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<SanPham> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM SanPham WHERE loaisp like :name");
			query.setString("name", "%" + loai + "%");
			query.setFirstResult(0);
			query.setMaxResults(40);
			list = (ArrayList<SanPham>) query.list();

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
	public SanPham getSanPhamByStt(int stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		SanPham sanpham = new SanPham();
		try {
			tx = session.beginTransaction();
			sanpham = (SanPham) session.createQuery("FROM SanPham WHERE stt = " + stt).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return sanpham;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SanPham> searchSanPham(String keyword) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<SanPham> list = new ArrayList<>();
		Query query;
		try {
			tx = session.beginTransaction();
			query = session.createQuery("FROM SanPham WHERE concat(loaisp, ' ', hangsx, ' ', ten) like :name");
			query.setString("name", "%" + keyword + "%");
			query.setFirstResult(0);
			query.setMaxResults(40);
			list = (ArrayList<SanPham>) query.list();

			if (list.size() == 0) {
				query = session.createQuery("FROM SanPham WHERE concat(loaisp, ' ', ten) like :name");
				query.setString("name", "%" + keyword + "%");
				query.setFirstResult(0);
				query.setMaxResults(40);
				list = (ArrayList<SanPham>) query.list();
			}

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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SanPham> getTopSanPham() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<SanPham> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM SanPham ORDER BY luotxem DESC");
			query.setFirstResult(0);
			query.setMaxResults(40);
			list = (ArrayList<SanPham>) query.list();

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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SanPham> getNewSanPham() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<SanPham> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM SanPham ORDER BY stt DESC");
			query.setFirstResult(0);
			query.setMaxResults(200);
			list = (ArrayList<SanPham>) query.list();

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
		// System.out.println(new SanPhamDAO().getAllSanPham());
		// System.out.println(new SanPhamDAO().getSanPhamByStt(18));
		// System.out.println(new SanPhamDAO().getNewSanPham());
		// System.out.println(new SanPhamDAO().getTopSanPham());
		// System.out.println(new SanPhamDAO().getSanPhamByLoai("Điện thoại"));

		// System.out.println(new SanPhamDAO().searchSanPham("Điện Thoại Apple
		// iPhone 6"));
		// new SanPhamDAO().insert(new SanPham());

		// SanPham sp = new SanPhamDAO().getSanPhamByStt(108);
		// sp.setGia(1000);
		// new SanPhamDAO().update(sp);

		// new SanPhamDAO().delete(108);

		// System.out.println(new SanPhamDAO().getAllSanPham(100000, 100000));
		System.out.println(new SanPhamDAO().delete(121));
		System.exit(0);
	}

}
