package dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.BaiViet;
import util.HibernateUtil;
import interfacce.Interface_BaiViet;

public class BaiVietDAO implements Interface_BaiViet {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save((BaiViet) obj);
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
			session.update((BaiViet) obj);
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
			String hql = "DELETE FROM BaiViet WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setInteger("id", (int)id);
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
	public ArrayList<BaiViet> getAllBaiViet() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<BaiViet> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<BaiViet>) session.createQuery("FROM BaiViet ORDER BY id DESC ").list();
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
	public ArrayList<BaiViet> getBaiVietByLoai(String loai) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<BaiViet> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM BaiViet WHERE loaitin like :name");
			query.setString("name", "%" + loai + "%");
			query.setFirstResult(0);
			query.setMaxResults(40);
			list = (ArrayList<BaiViet>) query.list();

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
	public BaiViet getBaiVietById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		BaiViet baiviet = new BaiViet();
		try {
			tx = session.beginTransaction();
			baiviet = (BaiViet) session.createQuery("FROM BaiViet WHERE id = " + id).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return baiviet;
	}
	
	public static void main(String[] args) {
		System.out.println(new BaiVietDAO().getBaiVietById(47));
		
		System.exit(0);
	}
}
