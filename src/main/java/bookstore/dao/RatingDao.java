package bookstore.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.swing.GroupLayout.Group;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import bookstore.entities.Rating;
import bookstore.utils.HibernateUtils;

public class RatingDao {
	public static RatingDao getInstance() {
		return new RatingDao();
	}

	public boolean save(Rating rating) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(rating);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Rating> findAll() throws Exception {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			String url = "SELECT * FROM RATINGS";

			Query<Rating> query = session.createNativeQuery(url).addEntity(Rating.class);

//			List<Rating> list = query.list();
//			
//			for (Rating rating : list) {
//				System.out.println(rating.toString());
//			}

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Object[]> searchAll() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			String url = "SELECT RT.*, RV.* FROM RATINGS RT JOIN REVIEW RV ON RT.rating_id = RV.rating_id";

			Query query = session.createNativeQuery(url).addEntity(Rating.class).addJoin("RV", "RT.reviews");

//			List<Object[]> list = query.list();

//			for (Object[] objects : list) {
//				Rating rating = (Rating) objects[0];
//				System.out.println(rating.toString());
//			}

			return query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean persist(Rating rating) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.persist(rating);

			transaction.commit();

			session.close();

			return (true);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void criteriaBuilderRating() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Rating> cirteria = builder.createQuery(Rating.class);

			Root<Rating> root = cirteria.from(Rating.class);

			cirteria.select(root);

			List<Rating> ratings = session.createQuery(cirteria).getResultList();

			for (Rating rating : ratings) {
				System.out.println(rating.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void criteriaBuilderAttribute() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Rating> cirteria = builder.createQuery(Rating.class);

			Root<Rating> root = cirteria.from(Rating.class);
			
			// Phải có constructor tương ứng
			cirteria.multiselect(root.get("ratingId"), root.get("status"));

			List<Rating> ratings = session.createQuery(cirteria).getResultList();

			for (Rating rating : ratings) {
				System.out.println(rating.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void criteriaBuilderMulti() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Object[]> cirteria = builder.createQuery(Object[].class);

			Root<Rating> root = cirteria.from(Rating.class);
			// Tên thuộc tính
			Path<Long> idPath = root.get("ratingId");
			Path<String> status = root.get("status"); 
			
			cirteria.select(builder.array(idPath, status));
			cirteria.where(builder.between(root.get("ratingId"), 2, 5));
			
			List<Object[]> idAndStatus = session.createQuery(cirteria).getResultList();
			
			for (Object[] objects : idAndStatus) {
				System.out.println(objects[0] + " " + objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void criteriaBuilderGroupBy() {
		Session session = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Object[]> cirteria = builder.createQuery(Object[].class);

			Root<Rating> root = cirteria.from(Rating.class);
			// Tên thuộc tính
			Path<Long> idPath = root.get("ratingId");
			Path<Double> status = root.get("status"); 
			Path<Long> review = root.get("numberOfReview");
			
			cirteria.multiselect(idPath, status, review);
			
			cirteria.groupBy(root.get("numberOfReview"));
			
			cirteria.having(builder.greaterThan(root.get("numberOfReview"), 1));
			
			cirteria.where(builder.between(root.get("ratingId"), 2, 5));
			
			List<Object[]> idAndStatus = session.createQuery(cirteria).getResultList();
			
			for (Object[] objects : idAndStatus) {
				System.out.println(objects[0] + " " + objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
