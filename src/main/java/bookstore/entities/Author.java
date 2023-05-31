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
@Table(name = "Author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int authorId;

	@Column(name = "full_name", nullable = false, columnDefinition = "NVARCHAR(50)", unique = true)
	private String fullName;

	@Column(name = "number_of_book")
	private int numberOfBook;

	@OneToMany(mappedBy = "author")
	private Set<Book> book;

	public Author() {
		
	}

	public Author(int authorId, String fullName, int numberOfBook, Set<Book> book) {
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
