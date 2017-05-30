package dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import interfacce.Interface_SanPham;
import model.SanPham;
import util.HibernateUtil;

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
	public boolean delete(long id) {
		Session session = sessionFactory.openSession();

		try {
			String hql = "DELETE FROM SanPham WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setInteger("id", (int) id);
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
			list = (ArrayList<SanPham>) session.createQuery("FROM SanPham ORDER BY id DESC ").list();
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
	public SanPham getSanPhamById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		SanPham sanpham = new SanPham();
		try {
			tx = session.beginTransaction();
			sanpham = (SanPham) session.createQuery("FROM SanPham WHERE id = " + id).uniqueResult();
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
	public ArrayList<SanPham> getAllTopSanPham() {
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
			Query query = session.createQuery("FROM SanPham ORDER BY id DESC");
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
		SanPhamDAO dao = new SanPhamDAO();

//		for (SanPham i : dao.getAllSanPham())
//			System.out.println(i);
		
//		System.out.println(dao.searchSanPham("iphone"));
		System.out.println(dao.getSanPhamById(98));
		
		System.exit(0);
	}

}
