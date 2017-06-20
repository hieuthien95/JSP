package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Category;
import util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	// thêm danh mục
	@Override
	public void insertCategory(Category c) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

	// lấy những danh mục là danh mục cha
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryByParent() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<Category> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM Category WHERE parent = 0").list();
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
	
	// lấy những danh mục là danh mục con
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryByChildren(int parent) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		List<Category> list = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM Category WHERE parent = '" + parent + "'").list();
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
		Category c = new Category(0, "menu1", 0);
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		categoryDAOImpl.insertCategory(c);
		for (Category i : categoryDAOImpl.getCategoryByChildren(2))
			System.out.println(i);
	}
}
