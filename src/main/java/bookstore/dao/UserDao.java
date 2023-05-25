package bookstore.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookstore.entities.UserAccount;
import bookstore.utils.HibernateUtils;

public class UserDao {
	public static UserDao getInstance() {
		return new UserDao();
	}
	
	public boolean save(UserAccount user) throws Exception{
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Serializable result = session.save(user);
			
			transaction.commit();
			
			return (result != null);
					
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
