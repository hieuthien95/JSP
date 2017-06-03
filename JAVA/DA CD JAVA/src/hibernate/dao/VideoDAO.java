package hibernate.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.interfacce.Interface_Video;
import hibernate.model.Video;
import hibernate.util.HibernateUtil;


public class VideoDAO implements Interface_Video {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public boolean insert(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save((Video) obj);
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
			session.update((Video) obj);
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
			session.delete(getVideoByStt((int) stt));
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
	public ArrayList<Video> getAllVideo() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		ArrayList<Video> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<Video>) session.createQuery("FROM Video ORDER BY stt DESC ").list();
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
	public Video getVideoByStt(int stt) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Video video = null;
		try {
			tx = session.beginTransaction();
			video = (Video) session.createQuery("FROM Video WHERE stt = " + stt).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return video;
	}

	public static void main(String[] args) {
		 VideoDAO dao = new VideoDAO();

		// System.out.println(dao.getAllVideo());
		// System.out.println(dao.getVideoByStt(32));

		// dao.insert(new Video(0,"ten", "hinhanh", 0, "duongdan", "noidung"));
		//
		// Video video = dao.getVideoByStt(37);
		// video.setDuongdan("0000000000");
		//
		// dao.update(video);

		 dao.delete(43);

		System.exit(0);
	}

}
