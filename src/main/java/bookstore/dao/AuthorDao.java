package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.Author;
import bookstore.utils.HibernateUtils;

public class AuthorDao {
	public static AuthorDao getInstance() {
		return new AuthorDao();
	}
	
	public boolean save(Author author) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(author);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
