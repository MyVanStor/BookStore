package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.PublishingHouse;
import bookstore.utils.HibernateUtils;

public class PublishingHouseDao {
	public static PublishingHouseDao getInstance() {
		return new PublishingHouseDao();
	}
	
	public boolean save(PublishingHouse publishingHouse) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(publishingHouse);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
