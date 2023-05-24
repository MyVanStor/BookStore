package bookstore.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book", schema = "dbo")
public class Book {
	@Id
	@Column(name = "Book_id")
	@GeneratedValue
	private int bookId;
	@Column(name = "Author_id", length = 255, nullable = false)
	private int authorId;
	@Column(name = "Title", length = 255)
	private String title;
	@Column(name = "Genres_id", nullable = false)
	private int genresId;
	@Column(name = "Level", nullable = false)
	private int level;
	@Column(name = "Artist", length = 255)
	private String artist;
	@Column(name = "Year_of_publishing", nullable = false)
	private Date year_of_publishing;
	@Column(name = "Publishing_house", nullable = false)
	private String publishingHouse;
	@Column(name = "Price", nullable = false)
	private double price;
	@Column(name = "Rating_rate")
	private double ratingRate;

	public Book() {
		
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGenresId() {
		return genresId;
	}

	public void setGenresId(int genresId) {
		this.genresId = genresId;
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

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRatingRate() {
		return ratingRate;
	}

	public void setRatingRate(double ratingRate) {
		this.ratingRate = ratingRate;
	}

	
}
