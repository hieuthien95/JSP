package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.Customer;

public class CustomerDao extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			tx = session.beginTransaction();
			list = (ArrayList<Customer>) session.createQuery("FROM Customer").list();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomerTemplate() {
		HibernateTemplate hibernateTemplate = getHibernateTemplate();

		return hibernateTemplate.find("FROM Customer");
	}

	public static void main(String[] args) {
		System.out.println(new CustomerDao().getAllCustomer());

		System.exit(0);
	}
}