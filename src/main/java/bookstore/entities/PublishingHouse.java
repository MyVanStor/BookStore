package bookstore.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Publishing_house", schema = "dbo")
public class PublishingHouse {
	@Id
	@Column(name = "publishing_house_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int publishingHouseId;

	@Column(name = "ph_name", nullable = false, unique = true, columnDefinition = "NVARCHAR(50)")
	private String name;

	@Column(name = "phone", nullable = false, unique = true)
	private String phone;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "address", nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
	private String address;

	@Column(name = "number_of_book")
	private int numberOfBook;

	@OneToMany(mappedBy = "publishingHouse")
	private Set<Book> book;

	public PublishingHouse() {

	}

	public PublishingHouse(int publishingHouseId, String name, String phone, String email, String address,
			int numberOfBook, Set<Book> book) {
		this.publishingHouseId = publishingHouseId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.numberOfBook = numberOfBook;
		this.book = book;
	}

	public int getPublishingHouseId() {
		return publishingHouseId;
	}

	public void setPublishingHouseId(int publishingHouseId) {
		this.publishingHouseId = publishingHouseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfBook() {
		return numberOfBook;
	}

	public void setNumberOfBook(int numberOfBook) {
		this.numberOfBook = numberOfBook;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

}
