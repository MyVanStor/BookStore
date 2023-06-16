package bookstore.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	@Column(name = "title", columnDefinition = "NVARCHAR(50)")
	private String title;

	@Column(name = "level", nullable = false)
	private int level;

	@Column(name = "artist", columnDefinition = "NVARCHAR(30)")
	private String artist;

	@Column(name = "year_of_publishing", nullable = false)
	private Date year_of_publishing;

	@Column(name = "price", nullable = false, precision = 10, scale = 2)
	private double price;

	@Column(name = "language", nullable = false, columnDefinition = "NVARCHAR(30)")
	private String language;

	@OneToOne()
	@JoinColumn(name = "rating_id")
	private Rating rating;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@OneToOne
	@JoinColumn(name = "file_attached_id")
	private FileAttached fileAttached;

	@ManyToOne
	@JoinColumn(name = "publishing_house_id")
	private PublishingHouse publishingHouse;

	@ManyToMany
	@JoinTable(name = "Category_Book", joinColumns = {
			@JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private Set<Category> category;

	@ManyToMany
	@JoinTable(name = "User_Book", joinColumns = {
			@JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "user_account_id") })
	private Set<UserAccount> user;

	@ManyToMany
	@JoinTable(name = "Book_OrderDetail", joinColumns = {
			@JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "order_detail_id") })
	private Set<OrderDetail> orderDetail;

	public Book() {

	}

	public Book(String title, int level, String artist, Date year_of_publishing, double price, String language,
			Rating rating, Author author, FileAttached fileAttached, PublishingHouse publishingHouse,
			Set<Category> category, Set<UserAccount> user, Set<OrderDetail> orderDetail) {
		this.title = title;
		this.level = level;
		this.artist = artist;
		this.year_of_publishing = year_of_publishing;
		this.price = price;
		this.language = language;
		this.rating = rating;
		this.author = author;
		this.fileAttached = fileAttached;
		this.publishingHouse = publishingHouse;
		this.category = category;
		this.user = user;
		this.orderDetail = orderDetail;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getYear_of_publishing() {
		return year_of_publishing;
	}

	public void setYear_of_publishing(Date year_of_publishing) {
		this.year_of_publishing = year_of_publishing;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public FileAttached getFileAttached() {
		return fileAttached;
	}

	public void setFileAttached(FileAttached fileAttached) {
		this.fileAttached = fileAttached;
	}

	public PublishingHouse getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(PublishingHouse publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Set<UserAccount> getUser() {
		return user;
	}

	public void setUser(Set<UserAccount> user) {
		this.user = user;
	}

	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

}
