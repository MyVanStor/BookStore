package bookstore.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int reviewId;

	@Column(name = "status", nullable = false, columnDefinition = "tinyint")
	private int status;

	@Column(name = "comment", columnDefinition = "NVARCHAR(100)")
	private String comment;

	@Column(name = "create_at", nullable = false, columnDefinition = "DATETIME")
	private Date createAt;

	@Column(name = "update_at", nullable = false, columnDefinition = "DATETIME")
	private Date updateAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rating_id")
	private Rating rating;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_account_id")
	private UserAccount user;

	public Review() {

	}

	public Review(int status, String comment, Date createAt, Date updateAt, Rating rating, UserAccount user) {
		this.status = status;
		this.comment = comment;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.rating = rating;
		this.user = user;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", status=" + status + ", comment=" + comment + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + "]";
	}

}
