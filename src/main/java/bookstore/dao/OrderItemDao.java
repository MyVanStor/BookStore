package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.OrderDetail;
import bookstore.utils.HibernateUtils;

public class OrderItemDao {
	public static OrderItemDao getInstance() {
		return new OrderItemDao();
	}
	
	public boolean save(OrderDetail orderItem) throws Exception{
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Serializable result = session.save(orderItem);
			
			transaction.commit();
			
			return (result != null);
					
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
