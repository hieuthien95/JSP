package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Category;
import model.Product;
import util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void insertProduct(Product p) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(p);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getListProduct() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<Product> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM Product ORDER BY product_id DESC").list();
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
	public List<Product> getListProductByCategory(int category_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<Product> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM Product WHERE category_id = '" + category_id + "'").list();
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
	public Product getListProductByProductID(int product_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		Product p = new Product();
		try {
			tx = session.beginTransaction();
			p = (Product) session.createQuery("FROM Product WHERE product_id = '" + product_id + "'").uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return p;
	}

	@Override
	public List<Product> getListProductByPages(List<Product> list, int start, int end) {
		List<Product> result = new ArrayList<>();
		for (int i = start; i < end; i++)
			result.add(list.get(i));
		return result;
	}

	public static void main(String[] args) {
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		List<Product> list = productDAOImpl.getListProduct();
		System.out.println(list.get(0));
	}

}
