package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.PayHistory;
import bookstore.utils.HibernateUtils;

public class PayHistoryDao {
	public static PayHistoryDao getInstance() {
		return new PayHistoryDao();
	}
	
	public boolean save(PayHistory payHistory) throws Exception{
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Serializable result = session.save(payHistory);
			
			transaction.commit();
			
			return (result != null);
					
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
