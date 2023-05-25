package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.OrderBook;
import bookstore.utils.HibernateUtils;

public class OrderBookDao {
	public static OrderBookDao getInstance() {
		return new OrderBookDao();
	}
	
	public boolean save(OrderBook order) throws Exception{
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Serializable result = session.save(order);
			
			transaction.commit();
			
			return (result != null);
					
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
