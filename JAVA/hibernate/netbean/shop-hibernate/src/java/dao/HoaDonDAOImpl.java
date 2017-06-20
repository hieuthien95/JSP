package dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.HoaDon;
import util.HibernateUtil;

public class HoaDonDAOImpl implements HoaDonDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public HoaDon insertHoaDon(HoaDon hoaDon) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(hoaDon);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return hoaDon;
	}
	
	public static void main(String[] args) {
		HoaDonDAOImpl hoaDonDAOImpl = new HoaDonDAOImpl();
		hoaDonDAOImpl.insertHoaDon(new HoaDon(0, "1", "278", "0152323", new Date()));
	
	}

}
