package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_BaiViet;
import hibernate.model.BaiViet;
import hibernate.util.HibernateUtil;



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
	public boolean delete(long stt) {
		Session session = sessionFactory.openSession();

		try {
			String hql = "DELETE FROM BaiViet WHERE stt = :stt";
			Query query = session.createQuery(hql);
			query.setInteger("stt", (int)stt);
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
			list = (ArrayList<BaiViet>) session.createQuery("FROM BaiViet ORDER BY stt DESC ").list();
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
	public BaiViet getBaiVietByStt(int stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		BaiViet baiviet = new BaiViet();
		try {
			tx = session.beginTransaction();
			baiviet = (BaiViet) session.createQuery("FROM BaiViet WHERE stt = " + stt).uniqueResult();
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
//		System.out.println(new BaiVietDAO().getAllBaiViet());
//		System.out.println(new BaiVietDAO().getBaiVietByLoai("Tin tức"));
//		System.out.println(new BaiVietDAO().getBaiVietByStt(47));
		
//		new BaiVietDAO().insert(new BaiViet(0, "loaitin", "tieude", "tomtat", "hinhanh", "noidung", 0));

//		BaiViet bv = new BaiVietDAO().getBaiVietByStt(62);
//		bv.setNoidung("hihih");
//		new BaiVietDAO().update(bv);
		
		new BaiVietDAO().delete(68);
		
		System.exit(0);
	}
}
