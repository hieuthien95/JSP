package dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import interfacce.Interface_DanhMuc;
import model.DanhMuc;
import util.HibernateUtil;

public class DanhMucDAO implements Interface_DanhMuc {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long stt) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<DanhMuc> getAllDanhMuc() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<DanhMuc> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc ORDER BY id DESC ").list();
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
	public ArrayList<DanhMuc> getAllDanhMucByParent(int parent) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<DanhMuc> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM DanhMuc WHERE parent = " + parent);
			query.setFirstResult(0);
			query.setMaxResults(40);
			list = (ArrayList<DanhMuc>) query.list();

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
	public DanhMuc getDanhMucById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		DanhMuc danhmuc = new DanhMuc();
		try {
			tx = session.beginTransaction();
			danhmuc = (DanhMuc) session.createQuery("FROM DanhMuc WHERE id = " + id).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return danhmuc;
	}
	
	public static void main(String[] args) {
		DanhMucDAO dao = new DanhMucDAO();
//		System.out.println(dao.getAllDanhMuc());
		
//		System.out.println(dao.getAllDanhMucByParent(0));
		
		System.out.println(dao.getDanhMucById(2));
		
		System.exit(0);
	}

}
