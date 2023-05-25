package bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ratings", schema = "dbo")
public class Rating {
	@Id
	@Column(name = "Rating_id")
	@GeneratedValue
	private int ratingId;

	@Column(name = "Status", nullable = false)
	private double status;

	@OneToOne(mappedBy = "rating")
	private Book book;

	public Rating() {

	}

	public Rating(int ratingId, double status, Book book) {
		super();
		this.ratingId = ratingId;
		this.status = status;
		this.book = book;
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
