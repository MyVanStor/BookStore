package bookstore.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import bookstore.entities.Review;
import bookstore.utils.HibernateUtils;

public class ReviewDao {
	public static ReviewDao getInstance() {
		return new ReviewDao();
	}

	public boolean save(Review review) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(review);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Review> findByComment(String comment) {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			String url = "SELECT * FROM REVIEW RV WHERE RV.COMMENT = :comment";

			Query<Review> query = session.createNativeQuery(url).addEntity(Review.class);

			query.setParameter("comment", comment);

			List<Review> list = query.list();

			for (Review review : list) {
				System.out.println(review.toString());
			}

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
