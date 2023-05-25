package bookstore.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User_account", schema = "dbo")
public class UserAccount {
	@Id
	@Column(name = "User_account_id")
	@GeneratedValue
	private int userId;

	@Column(name = "Username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "Password", length = 255, nullable = false)
	private String password;

	@Column(name = "Birthday")
	private Date birthday;

	@Column(name = "Full_name", nullable = false, length = 255)
	private String fullName;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@Column(name = "Budget", nullable = false, precision = 10, scale = 2)
	private double budget;

	@Column(name = "Phone", unique = true)
	private int phone;

	@OneToMany(mappedBy = "user")
	private Set<OrderBook> orderBook;

	@ManyToMany
	@JoinTable(name = "User_Book", schema = "dbo", joinColumns = {
			@JoinColumn(name = "User_account_id") }, inverseJoinColumns = { @JoinColumn(name = "Book_id") })
	private Set<Book> book;

	public UserAccount() {

	}

	public UserAccount(int userId, String username, String password, Date birthday, String fullName, String email,
			double budget, int phone, Set<OrderBook> orderBook, Set<Book> book) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.fullName = fullName;
		this.email = email;
		this.budget = budget;
		this.phone = phone;
		this.orderBook = orderBook;
		this.book = book;
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
