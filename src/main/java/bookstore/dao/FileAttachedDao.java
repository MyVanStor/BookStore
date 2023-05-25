package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.FileAttached;
import bookstore.utils.HibernateUtils;

public class FileAttachedDao {
	public static FileAttachedDao getInstance() {
		return new FileAttachedDao();
	}
	
	public boolean save(FileAttached fileAttached) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(fileAttached);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
