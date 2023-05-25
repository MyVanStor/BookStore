package bookstore.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Author", schema = "dbo")
public class Author {
	@Id
	@GeneratedValue
	@Column(name = "Author_id")
	private int authorId;

	@Column(name = "Full_name", nullable = false, length = 255)
	private String fullName;

	@Column(name = "Number_of_book")
	private int numberOfBook;

	@OneToMany(mappedBy = "author")
	private Set<Book> book;

	public Author() {
	}

	public Author(int authorId, String fullName, int numberOfBook, Set<Book> book) {
		super();
		this.authorId = authorId;
		this.fullName = fullName;
		this.numberOfBook = numberOfBook;
		this.book = book;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
