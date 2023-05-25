package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.Rating;
import bookstore.utils.HibernateUtils;

public class RatingDao {
	public static RatingDao getInstance() {
		return new RatingDao();
	}
	
	public boolean save(Rating ratings) throws Exception{
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Serializable result = session.save(ratings);
			
			transaction.commit();
			
			return (result != null);
					
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
