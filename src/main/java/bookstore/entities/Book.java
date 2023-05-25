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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book", schema = "dbo")
public class Book {
	@Id
	@Column(name = "Book_id")
	@GeneratedValue
	private int bookId;

	@Column(name = "Title", length = 255)
	private String title;

	@Column(name = "Level", nullable = false)
	private int level;

	@Column(name = "Artist", length = 255)
	private String artist;

	@Column(name = "Year_of_publishing", nullable = false)
	private Date year_of_publishing;

	@Column(name = "Price", nullable = false)
	private double price;

	@OneToOne(mappedBy = "book")
	private OrderItem orderItem;

	@OneToOne()
	@JoinColumn(name = "Rating_id")
	private Rating rating;

	@ManyToOne
	@JoinColumn(name = "Author_id")
	private Author author;

	@OneToOne
	@JoinColumn(name = "File_attached_id")
	private FileAttached fileAttached;

	@ManyToOne
	@JoinColumn(name = "Publishing_house_id")
	private PublishingHouse publishingHouse;

	@ManyToMany
	@JoinTable(name = "Category_Book", schema = "dbo", joinColumns = {
			@JoinColumn(name = "Book_id") }, inverseJoinColumns = { @JoinColumn(name = "Category_id") })
	private Set<Category> category;

	@ManyToMany
	@JoinTable(name = "User_Book", schema = "dbo", joinColumns = {
			@JoinColumn(name = "Book_id") }, inverseJoinColumns = { @JoinColumn(name = "User_account_id") })
	private Set<UserAccount> user;

	public Book() {

	}

	public Book(int bookId, String title, int level, String artist, Date year_of_publishing, double price,
			OrderItem orderItem, Rating rating, Author author, FileAttached fileAttached,
			PublishingHouse publishingHouse, Set<Category> category, Set<UserAccount> user) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.level = level;
		this.artist = artist;
		this.year_of_publishing = year_of_publishing;
		this.price = price;
		this.orderItem = orderItem;
		this.rating = rating;
		this.author = author;
		this.fileAttached = fileAttached;
		this.publishingHouse = publishingHouse;
		this.category = category;
		this.user = user;
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

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
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

}
