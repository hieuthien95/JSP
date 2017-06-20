package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietHoaDon;
import util.HibernateUtil;

public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void insertChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(chiTietHoaDon);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		ChiTietHoaDonDAOImpl chiTietHoaDonDAOImpl = new ChiTietHoaDonDAOImpl();
		chiTietHoaDonDAOImpl.insertChiTietHoaDon(new ChiTietHoaDon(0, 1, 2, 3, 40));
	}

}
