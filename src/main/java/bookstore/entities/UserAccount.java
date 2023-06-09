package bookstore.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User_account")
public class UserAccount {
	@Id
	@Column(name = "user_account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "full_name", nullable = false, columnDefinition = "NVARCHAR(50)")
	private String fullName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "budget", nullable = false, precision = 10, scale = 2)
	private double budget;

	@Column(name = "phone", unique = true)
	private int phone;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "role")
	private String role;
	@OneToMany(mappedBy = "user")
	private Set<OrderBook> orderBook;

	@ManyToMany(mappedBy = "user")
	private Set<Book> book;

	@OneToMany(mappedBy = "user")
	private Set<Review> review;

	@OneToMany(mappedBy = "user")
	private Set<PayHistory> payHistories;

	public UserAccount() {

	}

	public UserAccount(String username, String password, Date birthday, String fullName, String email, double budget,
			int phone, String sex, Set<OrderBook> orderBook, Set<Book> book, Set<Review> review,
			Set<PayHistory> payHistories) {
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.fullName = fullName;
		this.email = email;
		this.budget = budget;
		this.phone = phone;
		this.sex = sex;
		this.orderBook = orderBook;
		this.book = book;
		this.review = review;
		this.payHistories = payHistories;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	public Set<PayHistory> getPayHistories() {
		return payHistories;
	}

	public void setPayHistories(Set<PayHistory> payHistories) {
		this.payHistories = payHistories;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Set<OrderBook> getOrderBook() {
		return orderBook;
	}

	public void setOrderBook(Set<OrderBook> orderBook) {
		this.orderBook = orderBook;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

}
