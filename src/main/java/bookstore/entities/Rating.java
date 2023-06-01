package bookstore.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ratings")
public class Rating {
	@Id
	@Column(name = "rating_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;

	@Column(name = "status", nullable = false, columnDefinition = "TINYINT")
	private double status;

	@Column(name = "number_of_review")
	private int numberOfReview;

	@OneToOne(mappedBy = "rating")
	private Book book;

	@OneToMany(mappedBy = "rating")
	private Set<Review> review;

	public Rating() {

	}

	public Rating(double status, int numberOfReview, Book book, Set<Review> review) {
		this.status = status;
		this.numberOfReview = numberOfReview;
		this.book = book;
		this.review = review;
	}

	public int getNumberOfReview() {
		return numberOfReview;
	}

	public void setNumberOfReview(int numberOfReview) {
		this.numberOfReview = numberOfReview;
	}

	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public double getStatus() {
		return status;
	}

	public void setStatus(double status) {
		this.status = status;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
