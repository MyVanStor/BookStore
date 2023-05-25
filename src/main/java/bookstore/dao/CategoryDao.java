package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.Category;
import bookstore.utils.HibernateUtils;

public class CategoryDao {
	public static CategoryDao getInstance() {
		return new CategoryDao();
	}
	
	public boolean save(Category category) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(category);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
