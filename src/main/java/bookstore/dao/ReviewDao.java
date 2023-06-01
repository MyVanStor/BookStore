package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.Review;
import bookstore.utils.HibernateUtils;

public class ReviewDao {
	public static ReviewDao getInstance() {
		return new ReviewDao();
	}
	
	public boolean save(Review review) throws Exception{
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Serializable result = session.save(review);
			
			transaction.commit();
			
			return (result != null);
					
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
